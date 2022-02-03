package essam.com.example.Shift.Application.controllers;

import essam.com.example.Shift.Application.grpc.*;
import essam.com.example.Shift.Application.models.Shift;
import essam.com.example.Shift.Application.models.User;
import essam.com.example.Shift.Application.repositories.ShiftRepository;
import essam.com.example.Shift.Application.services.ShiftsService;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;

@GRpcService
public class ShiftsControllerGrpc extends ShiftServiceGrpc.ShiftServiceImplBase {
    @Autowired
    ShiftRepository repository;

    @Autowired
    ShiftsService service;

    @Override
    public void findOne(Shifts.FindOneShiftRequest request, StreamObserver<Shifts.OneShiftResponse> responseObserver) {
        Shift shift = repository.findById((Long) request.getId()).get();
        Shifts.OneShiftResponse response = Shifts.OneShiftResponse.newBuilder()
                .setId(shift.getId())
                .setStartTime(shift.getStartTime().getTime())
                .setEndTime(shift.getEndTime().getTime())
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void find(Shifts.FindShifts request, StreamObserver<Shifts.OneShiftResponse> responseObserver) {
        repository.findAll().stream().map(s -> Shifts.OneShiftResponse.newBuilder()
                .setId(s.getId())
                .setStartTime(s.getStartTime().getTime())
                .setEndTime(s.getEndTime().getTime())
                .build()
        ).forEach(responseObserver::onNext);
        responseObserver.onCompleted();
    }

    @Override
    public void createShift(Shifts.CreateShiftRequest request, StreamObserver<Shifts.OneShiftResponse> responseObserver) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Shift shift = service.create(user, request);
        Shifts.OneShiftResponse response = Shifts.OneShiftResponse
                .newBuilder()
                .setId(shift.getId())
                .setStartTime(shift.getStartTime().getTime())
                .setEndTime(shift.getEndTime().getTime())
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}

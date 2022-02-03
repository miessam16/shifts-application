package essam.com.example.Shift.Application.controllers;

import essam.com.example.Shift.Application.grpc.AuthServiceGrpc;
import essam.com.example.Shift.Application.grpc.LoginRequest;
import essam.com.example.Shift.Application.grpc.LoginResponse;
import essam.com.example.Shift.Application.services.AuthService;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.factory.annotation.Autowired;

@GRpcService
public class AuthControllerGrpc extends AuthServiceGrpc.AuthServiceImplBase {
    @Autowired
    private AuthService authService;


    @Override
    public void login(LoginRequest request, StreamObserver<LoginResponse> responseObserver) {
        LoginResponse response = LoginResponse.newBuilder().setToken(authService.login(request)).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}

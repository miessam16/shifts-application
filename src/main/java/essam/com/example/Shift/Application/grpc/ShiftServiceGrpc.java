package essam.com.example.Shift.Application.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.16.1)",
    comments = "Source: shifts.proto")
public final class ShiftServiceGrpc {

  private ShiftServiceGrpc() {}

  public static final String SERVICE_NAME = "essam.com.example.Shift.Application.ShiftService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<essam.com.example.Shift.Application.grpc.Shifts.FindOneShiftRequest,
      essam.com.example.Shift.Application.grpc.Shifts.OneShiftResponse> getFindOneMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "findOne",
      requestType = essam.com.example.Shift.Application.grpc.Shifts.FindOneShiftRequest.class,
      responseType = essam.com.example.Shift.Application.grpc.Shifts.OneShiftResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<essam.com.example.Shift.Application.grpc.Shifts.FindOneShiftRequest,
      essam.com.example.Shift.Application.grpc.Shifts.OneShiftResponse> getFindOneMethod() {
    io.grpc.MethodDescriptor<essam.com.example.Shift.Application.grpc.Shifts.FindOneShiftRequest, essam.com.example.Shift.Application.grpc.Shifts.OneShiftResponse> getFindOneMethod;
    if ((getFindOneMethod = ShiftServiceGrpc.getFindOneMethod) == null) {
      synchronized (ShiftServiceGrpc.class) {
        if ((getFindOneMethod = ShiftServiceGrpc.getFindOneMethod) == null) {
          ShiftServiceGrpc.getFindOneMethod = getFindOneMethod = 
              io.grpc.MethodDescriptor.<essam.com.example.Shift.Application.grpc.Shifts.FindOneShiftRequest, essam.com.example.Shift.Application.grpc.Shifts.OneShiftResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "essam.com.example.Shift.Application.ShiftService", "findOne"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  essam.com.example.Shift.Application.grpc.Shifts.FindOneShiftRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  essam.com.example.Shift.Application.grpc.Shifts.OneShiftResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ShiftServiceMethodDescriptorSupplier("findOne"))
                  .build();
          }
        }
     }
     return getFindOneMethod;
  }

  private static volatile io.grpc.MethodDescriptor<essam.com.example.Shift.Application.grpc.Shifts.FindShifts,
      essam.com.example.Shift.Application.grpc.Shifts.OneShiftResponse> getFindMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "find",
      requestType = essam.com.example.Shift.Application.grpc.Shifts.FindShifts.class,
      responseType = essam.com.example.Shift.Application.grpc.Shifts.OneShiftResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<essam.com.example.Shift.Application.grpc.Shifts.FindShifts,
      essam.com.example.Shift.Application.grpc.Shifts.OneShiftResponse> getFindMethod() {
    io.grpc.MethodDescriptor<essam.com.example.Shift.Application.grpc.Shifts.FindShifts, essam.com.example.Shift.Application.grpc.Shifts.OneShiftResponse> getFindMethod;
    if ((getFindMethod = ShiftServiceGrpc.getFindMethod) == null) {
      synchronized (ShiftServiceGrpc.class) {
        if ((getFindMethod = ShiftServiceGrpc.getFindMethod) == null) {
          ShiftServiceGrpc.getFindMethod = getFindMethod = 
              io.grpc.MethodDescriptor.<essam.com.example.Shift.Application.grpc.Shifts.FindShifts, essam.com.example.Shift.Application.grpc.Shifts.OneShiftResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "essam.com.example.Shift.Application.ShiftService", "find"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  essam.com.example.Shift.Application.grpc.Shifts.FindShifts.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  essam.com.example.Shift.Application.grpc.Shifts.OneShiftResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ShiftServiceMethodDescriptorSupplier("find"))
                  .build();
          }
        }
     }
     return getFindMethod;
  }

  private static volatile io.grpc.MethodDescriptor<essam.com.example.Shift.Application.grpc.Shifts.CreateShiftRequest,
      essam.com.example.Shift.Application.grpc.Shifts.OneShiftResponse> getCreateShiftMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "createShift",
      requestType = essam.com.example.Shift.Application.grpc.Shifts.CreateShiftRequest.class,
      responseType = essam.com.example.Shift.Application.grpc.Shifts.OneShiftResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<essam.com.example.Shift.Application.grpc.Shifts.CreateShiftRequest,
      essam.com.example.Shift.Application.grpc.Shifts.OneShiftResponse> getCreateShiftMethod() {
    io.grpc.MethodDescriptor<essam.com.example.Shift.Application.grpc.Shifts.CreateShiftRequest, essam.com.example.Shift.Application.grpc.Shifts.OneShiftResponse> getCreateShiftMethod;
    if ((getCreateShiftMethod = ShiftServiceGrpc.getCreateShiftMethod) == null) {
      synchronized (ShiftServiceGrpc.class) {
        if ((getCreateShiftMethod = ShiftServiceGrpc.getCreateShiftMethod) == null) {
          ShiftServiceGrpc.getCreateShiftMethod = getCreateShiftMethod = 
              io.grpc.MethodDescriptor.<essam.com.example.Shift.Application.grpc.Shifts.CreateShiftRequest, essam.com.example.Shift.Application.grpc.Shifts.OneShiftResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "essam.com.example.Shift.Application.ShiftService", "createShift"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  essam.com.example.Shift.Application.grpc.Shifts.CreateShiftRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  essam.com.example.Shift.Application.grpc.Shifts.OneShiftResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ShiftServiceMethodDescriptorSupplier("createShift"))
                  .build();
          }
        }
     }
     return getCreateShiftMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ShiftServiceStub newStub(io.grpc.Channel channel) {
    return new ShiftServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ShiftServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ShiftServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ShiftServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ShiftServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class ShiftServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void findOne(essam.com.example.Shift.Application.grpc.Shifts.FindOneShiftRequest request,
        io.grpc.stub.StreamObserver<essam.com.example.Shift.Application.grpc.Shifts.OneShiftResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getFindOneMethod(), responseObserver);
    }

    /**
     */
    public void find(essam.com.example.Shift.Application.grpc.Shifts.FindShifts request,
        io.grpc.stub.StreamObserver<essam.com.example.Shift.Application.grpc.Shifts.OneShiftResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getFindMethod(), responseObserver);
    }

    /**
     */
    public void createShift(essam.com.example.Shift.Application.grpc.Shifts.CreateShiftRequest request,
        io.grpc.stub.StreamObserver<essam.com.example.Shift.Application.grpc.Shifts.OneShiftResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateShiftMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getFindOneMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                essam.com.example.Shift.Application.grpc.Shifts.FindOneShiftRequest,
                essam.com.example.Shift.Application.grpc.Shifts.OneShiftResponse>(
                  this, METHODID_FIND_ONE)))
          .addMethod(
            getFindMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                essam.com.example.Shift.Application.grpc.Shifts.FindShifts,
                essam.com.example.Shift.Application.grpc.Shifts.OneShiftResponse>(
                  this, METHODID_FIND)))
          .addMethod(
            getCreateShiftMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                essam.com.example.Shift.Application.grpc.Shifts.CreateShiftRequest,
                essam.com.example.Shift.Application.grpc.Shifts.OneShiftResponse>(
                  this, METHODID_CREATE_SHIFT)))
          .build();
    }
  }

  /**
   */
  public static final class ShiftServiceStub extends io.grpc.stub.AbstractStub<ShiftServiceStub> {
    private ShiftServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ShiftServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ShiftServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ShiftServiceStub(channel, callOptions);
    }

    /**
     */
    public void findOne(essam.com.example.Shift.Application.grpc.Shifts.FindOneShiftRequest request,
        io.grpc.stub.StreamObserver<essam.com.example.Shift.Application.grpc.Shifts.OneShiftResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getFindOneMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void find(essam.com.example.Shift.Application.grpc.Shifts.FindShifts request,
        io.grpc.stub.StreamObserver<essam.com.example.Shift.Application.grpc.Shifts.OneShiftResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getFindMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void createShift(essam.com.example.Shift.Application.grpc.Shifts.CreateShiftRequest request,
        io.grpc.stub.StreamObserver<essam.com.example.Shift.Application.grpc.Shifts.OneShiftResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateShiftMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ShiftServiceBlockingStub extends io.grpc.stub.AbstractStub<ShiftServiceBlockingStub> {
    private ShiftServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ShiftServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ShiftServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ShiftServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public essam.com.example.Shift.Application.grpc.Shifts.OneShiftResponse findOne(essam.com.example.Shift.Application.grpc.Shifts.FindOneShiftRequest request) {
      return blockingUnaryCall(
          getChannel(), getFindOneMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<essam.com.example.Shift.Application.grpc.Shifts.OneShiftResponse> find(
        essam.com.example.Shift.Application.grpc.Shifts.FindShifts request) {
      return blockingServerStreamingCall(
          getChannel(), getFindMethod(), getCallOptions(), request);
    }

    /**
     */
    public essam.com.example.Shift.Application.grpc.Shifts.OneShiftResponse createShift(essam.com.example.Shift.Application.grpc.Shifts.CreateShiftRequest request) {
      return blockingUnaryCall(
          getChannel(), getCreateShiftMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ShiftServiceFutureStub extends io.grpc.stub.AbstractStub<ShiftServiceFutureStub> {
    private ShiftServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ShiftServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ShiftServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ShiftServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<essam.com.example.Shift.Application.grpc.Shifts.OneShiftResponse> findOne(
        essam.com.example.Shift.Application.grpc.Shifts.FindOneShiftRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getFindOneMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<essam.com.example.Shift.Application.grpc.Shifts.OneShiftResponse> createShift(
        essam.com.example.Shift.Application.grpc.Shifts.CreateShiftRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateShiftMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_FIND_ONE = 0;
  private static final int METHODID_FIND = 1;
  private static final int METHODID_CREATE_SHIFT = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ShiftServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ShiftServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_FIND_ONE:
          serviceImpl.findOne((essam.com.example.Shift.Application.grpc.Shifts.FindOneShiftRequest) request,
              (io.grpc.stub.StreamObserver<essam.com.example.Shift.Application.grpc.Shifts.OneShiftResponse>) responseObserver);
          break;
        case METHODID_FIND:
          serviceImpl.find((essam.com.example.Shift.Application.grpc.Shifts.FindShifts) request,
              (io.grpc.stub.StreamObserver<essam.com.example.Shift.Application.grpc.Shifts.OneShiftResponse>) responseObserver);
          break;
        case METHODID_CREATE_SHIFT:
          serviceImpl.createShift((essam.com.example.Shift.Application.grpc.Shifts.CreateShiftRequest) request,
              (io.grpc.stub.StreamObserver<essam.com.example.Shift.Application.grpc.Shifts.OneShiftResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class ShiftServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ShiftServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return essam.com.example.Shift.Application.grpc.Shifts.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ShiftService");
    }
  }

  private static final class ShiftServiceFileDescriptorSupplier
      extends ShiftServiceBaseDescriptorSupplier {
    ShiftServiceFileDescriptorSupplier() {}
  }

  private static final class ShiftServiceMethodDescriptorSupplier
      extends ShiftServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ShiftServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (ShiftServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ShiftServiceFileDescriptorSupplier())
              .addMethod(getFindOneMethod())
              .addMethod(getFindMethod())
              .addMethod(getCreateShiftMethod())
              .build();
        }
      }
    }
    return result;
  }
}

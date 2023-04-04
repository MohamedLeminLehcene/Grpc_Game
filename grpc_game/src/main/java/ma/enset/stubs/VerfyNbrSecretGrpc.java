package ma.enset.stubs;

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
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: jeu.proto")
public final class VerfyNbrSecretGrpc {

  private VerfyNbrSecretGrpc() {}

  public static final String SERVICE_NAME = "VerfyNbrSecret";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<ma.enset.stubs.Jeu.ClientRequest,
      ma.enset.stubs.Jeu.ClientResponse> getFullClientRequestMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "fullClientRequest",
      requestType = ma.enset.stubs.Jeu.ClientRequest.class,
      responseType = ma.enset.stubs.Jeu.ClientResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<ma.enset.stubs.Jeu.ClientRequest,
      ma.enset.stubs.Jeu.ClientResponse> getFullClientRequestMethod() {
    io.grpc.MethodDescriptor<ma.enset.stubs.Jeu.ClientRequest, ma.enset.stubs.Jeu.ClientResponse> getFullClientRequestMethod;
    if ((getFullClientRequestMethod = VerfyNbrSecretGrpc.getFullClientRequestMethod) == null) {
      synchronized (VerfyNbrSecretGrpc.class) {
        if ((getFullClientRequestMethod = VerfyNbrSecretGrpc.getFullClientRequestMethod) == null) {
          VerfyNbrSecretGrpc.getFullClientRequestMethod = getFullClientRequestMethod = 
              io.grpc.MethodDescriptor.<ma.enset.stubs.Jeu.ClientRequest, ma.enset.stubs.Jeu.ClientResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "VerfyNbrSecret", "fullClientRequest"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ma.enset.stubs.Jeu.ClientRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ma.enset.stubs.Jeu.ClientResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new VerfyNbrSecretMethodDescriptorSupplier("fullClientRequest"))
                  .build();
          }
        }
     }
     return getFullClientRequestMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static VerfyNbrSecretStub newStub(io.grpc.Channel channel) {
    return new VerfyNbrSecretStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static VerfyNbrSecretBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new VerfyNbrSecretBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static VerfyNbrSecretFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new VerfyNbrSecretFutureStub(channel);
  }

  /**
   */
  public static abstract class VerfyNbrSecretImplBase implements io.grpc.BindableService {

    /**
     */
    public io.grpc.stub.StreamObserver<ma.enset.stubs.Jeu.ClientRequest> fullClientRequest(
        io.grpc.stub.StreamObserver<ma.enset.stubs.Jeu.ClientResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getFullClientRequestMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getFullClientRequestMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                ma.enset.stubs.Jeu.ClientRequest,
                ma.enset.stubs.Jeu.ClientResponse>(
                  this, METHODID_FULL_CLIENT_REQUEST)))
          .build();
    }
  }

  /**
   */
  public static final class VerfyNbrSecretStub extends io.grpc.stub.AbstractStub<VerfyNbrSecretStub> {
    private VerfyNbrSecretStub(io.grpc.Channel channel) {
      super(channel);
    }

    private VerfyNbrSecretStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected VerfyNbrSecretStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new VerfyNbrSecretStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<ma.enset.stubs.Jeu.ClientRequest> fullClientRequest(
        io.grpc.stub.StreamObserver<ma.enset.stubs.Jeu.ClientResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getFullClientRequestMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class VerfyNbrSecretBlockingStub extends io.grpc.stub.AbstractStub<VerfyNbrSecretBlockingStub> {
    private VerfyNbrSecretBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private VerfyNbrSecretBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected VerfyNbrSecretBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new VerfyNbrSecretBlockingStub(channel, callOptions);
    }
  }

  /**
   */
  public static final class VerfyNbrSecretFutureStub extends io.grpc.stub.AbstractStub<VerfyNbrSecretFutureStub> {
    private VerfyNbrSecretFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private VerfyNbrSecretFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected VerfyNbrSecretFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new VerfyNbrSecretFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_FULL_CLIENT_REQUEST = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final VerfyNbrSecretImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(VerfyNbrSecretImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_FULL_CLIENT_REQUEST:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.fullClientRequest(
              (io.grpc.stub.StreamObserver<ma.enset.stubs.Jeu.ClientResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class VerfyNbrSecretBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    VerfyNbrSecretBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return ma.enset.stubs.Jeu.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("VerfyNbrSecret");
    }
  }

  private static final class VerfyNbrSecretFileDescriptorSupplier
      extends VerfyNbrSecretBaseDescriptorSupplier {
    VerfyNbrSecretFileDescriptorSupplier() {}
  }

  private static final class VerfyNbrSecretMethodDescriptorSupplier
      extends VerfyNbrSecretBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    VerfyNbrSecretMethodDescriptorSupplier(String methodName) {
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
      synchronized (VerfyNbrSecretGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new VerfyNbrSecretFileDescriptorSupplier())
              .addMethod(getFullClientRequestMethod())
              .build();
        }
      }
    }
    return result;
  }
}

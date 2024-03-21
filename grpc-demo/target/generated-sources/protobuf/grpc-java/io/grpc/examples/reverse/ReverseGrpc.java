package io.grpc.examples.reverse;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * The greeting service definition.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.54.0)",
    comments = "Source: reverse.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ReverseGrpc {

  private ReverseGrpc() {}

  public static final String SERVICE_NAME = "reverse.Reverse";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<io.grpc.examples.reverse.ReverseRequest,
      io.grpc.examples.reverse.ReverseReply> getReverseStringMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ReverseString",
      requestType = io.grpc.examples.reverse.ReverseRequest.class,
      responseType = io.grpc.examples.reverse.ReverseReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<io.grpc.examples.reverse.ReverseRequest,
      io.grpc.examples.reverse.ReverseReply> getReverseStringMethod() {
    io.grpc.MethodDescriptor<io.grpc.examples.reverse.ReverseRequest, io.grpc.examples.reverse.ReverseReply> getReverseStringMethod;
    if ((getReverseStringMethod = ReverseGrpc.getReverseStringMethod) == null) {
      synchronized (ReverseGrpc.class) {
        if ((getReverseStringMethod = ReverseGrpc.getReverseStringMethod) == null) {
          ReverseGrpc.getReverseStringMethod = getReverseStringMethod =
              io.grpc.MethodDescriptor.<io.grpc.examples.reverse.ReverseRequest, io.grpc.examples.reverse.ReverseReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ReverseString"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.examples.reverse.ReverseRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.examples.reverse.ReverseReply.getDefaultInstance()))
              .setSchemaDescriptor(new ReverseMethodDescriptorSupplier("ReverseString"))
              .build();
        }
      }
    }
    return getReverseStringMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ReverseStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ReverseStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ReverseStub>() {
        @java.lang.Override
        public ReverseStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ReverseStub(channel, callOptions);
        }
      };
    return ReverseStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ReverseBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ReverseBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ReverseBlockingStub>() {
        @java.lang.Override
        public ReverseBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ReverseBlockingStub(channel, callOptions);
        }
      };
    return ReverseBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ReverseFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ReverseFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ReverseFutureStub>() {
        @java.lang.Override
        public ReverseFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ReverseFutureStub(channel, callOptions);
        }
      };
    return ReverseFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * The greeting service definition.
   * </pre>
   */
  public interface AsyncService {

    /**
     * <pre>
     * Sends a message to reverse
     * </pre>
     */
    default void reverseString(io.grpc.examples.reverse.ReverseRequest request,
        io.grpc.stub.StreamObserver<io.grpc.examples.reverse.ReverseReply> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getReverseStringMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service Reverse.
   * <pre>
   * The greeting service definition.
   * </pre>
   */
  public static abstract class ReverseImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return ReverseGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service Reverse.
   * <pre>
   * The greeting service definition.
   * </pre>
   */
  public static final class ReverseStub
      extends io.grpc.stub.AbstractAsyncStub<ReverseStub> {
    private ReverseStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ReverseStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ReverseStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends a message to reverse
     * </pre>
     */
    public void reverseString(io.grpc.examples.reverse.ReverseRequest request,
        io.grpc.stub.StreamObserver<io.grpc.examples.reverse.ReverseReply> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getReverseStringMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service Reverse.
   * <pre>
   * The greeting service definition.
   * </pre>
   */
  public static final class ReverseBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ReverseBlockingStub> {
    private ReverseBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ReverseBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ReverseBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends a message to reverse
     * </pre>
     */
    public io.grpc.examples.reverse.ReverseReply reverseString(io.grpc.examples.reverse.ReverseRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getReverseStringMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service Reverse.
   * <pre>
   * The greeting service definition.
   * </pre>
   */
  public static final class ReverseFutureStub
      extends io.grpc.stub.AbstractFutureStub<ReverseFutureStub> {
    private ReverseFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ReverseFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ReverseFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends a message to reverse
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<io.grpc.examples.reverse.ReverseReply> reverseString(
        io.grpc.examples.reverse.ReverseRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getReverseStringMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_REVERSE_STRING = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_REVERSE_STRING:
          serviceImpl.reverseString((io.grpc.examples.reverse.ReverseRequest) request,
              (io.grpc.stub.StreamObserver<io.grpc.examples.reverse.ReverseReply>) responseObserver);
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

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getReverseStringMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              io.grpc.examples.reverse.ReverseRequest,
              io.grpc.examples.reverse.ReverseReply>(
                service, METHODID_REVERSE_STRING)))
        .build();
  }

  private static abstract class ReverseBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ReverseBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return io.grpc.examples.reverse.ReverseProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Reverse");
    }
  }

  private static final class ReverseFileDescriptorSupplier
      extends ReverseBaseDescriptorSupplier {
    ReverseFileDescriptorSupplier() {}
  }

  private static final class ReverseMethodDescriptorSupplier
      extends ReverseBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ReverseMethodDescriptorSupplier(String methodName) {
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
      synchronized (ReverseGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ReverseFileDescriptorSupplier())
              .addMethod(getReverseStringMethod())
              .build();
        }
      }
    }
    return result;
  }
}

// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: auth.proto

package essam.com.example.Shift.Application.grpc;

public final class Auth {
  private Auth() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_essam_com_example_Shift_Application_LoginRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_essam_com_example_Shift_Application_LoginRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_essam_com_example_Shift_Application_LoginResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_essam_com_example_Shift_Application_LoginResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\nauth.proto\022#essam.com.example.Shift.Ap" +
      "plication\"5\n\014LoginRequest\022\023\n\013phoneNumber" +
      "\030\001 \001(\t\022\020\n\010password\030\002 \001(\t\"\036\n\rLoginRespons" +
      "e\022\r\n\005token\030\001 \001(\t2}\n\013AuthService\022n\n\005Login" +
      "\0221.essam.com.example.Shift.Application.L" +
      "oginRequest\0322.essam.com.example.Shift.Ap" +
      "plication.LoginResponseB2\n(essam.com.exa" +
      "mple.Shift.Application.grpcB\004AuthP\001b\006pro" +
      "to3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_essam_com_example_Shift_Application_LoginRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_essam_com_example_Shift_Application_LoginRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_essam_com_example_Shift_Application_LoginRequest_descriptor,
        new java.lang.String[] { "PhoneNumber", "Password", });
    internal_static_essam_com_example_Shift_Application_LoginResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_essam_com_example_Shift_Application_LoginResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_essam_com_example_Shift_Application_LoginResponse_descriptor,
        new java.lang.String[] { "Token", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
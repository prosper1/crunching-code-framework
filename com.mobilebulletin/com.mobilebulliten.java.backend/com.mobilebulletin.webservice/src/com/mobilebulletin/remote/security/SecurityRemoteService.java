/**
 * SecurityRemoteService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.mobilebulletin.remote.security;

public interface SecurityRemoteService extends java.rmi.Remote {
    public com.mobilebulletin.remote.security.ActivateAccountResponse activateAccount(com.mobilebulletin.remote.security.ActivateAccountRequest arg0) throws java.rmi.RemoteException;
    public com.mobilebulletin.remote.security.CheckUserResponse checkUser(com.mobilebulletin.remote.security.CheckUserRequest arg0) throws java.rmi.RemoteException;
    public com.mobilebulletin.remote.security.GenerateTypesResponse generateTypes(com.mobilebulletin.remote.security.GenerateTypesRequest arg0) throws java.rmi.RemoteException;
    public com.mobilebulletin.remote.security.UpdateUserInfoResponse updateUserInfo(com.mobilebulletin.remote.security.UpdateUserInfoRequest arg0) throws java.rmi.RemoteException;
    public com.mobilebulletin.remote.security.SignUpUserResponse signUpUser(com.mobilebulletin.remote.security.SignUpUserRequest arg0) throws java.rmi.RemoteException;
    public com.mobilebulletin.remote.security.GetUserInfoResponse getUserInfo(com.mobilebulletin.remote.security.GetUserInfoRequest arg0) throws java.rmi.RemoteException;
    public com.mobilebulletin.remote.security.ChangePasswordResponse changePassword(com.mobilebulletin.remote.security.ChangePasswordRequest arg0) throws java.rmi.RemoteException;
    public com.mobilebulletin.remote.security.SignInResponse signIn(com.mobilebulletin.remote.security.SignInRequest arg0) throws java.rmi.RemoteException;
    public com.mobilebulletin.remote.security.ForgotPasswordResponse forgotPassword(com.mobilebulletin.remote.security.ForgotPasswordRequest arg0) throws java.rmi.RemoteException;
    public com.mobilebulletin.remote.security.UpdateUserRoleResponse updateUserRole(com.mobilebulletin.remote.security.UpdateUserRoleRequest arg0) throws java.rmi.RemoteException;
}

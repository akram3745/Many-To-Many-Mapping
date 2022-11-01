package com.techno.mapping.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.techno.mapping.exception.EmployeeNotFound;
import com.techno.mapping.response.ResponseMessage;

@RestControllerAdvice
public class EmployeeExceptionHandler {

	@ExceptionHandler(value = EmployeeNotFound.class)
	public ResponseEntity<ResponseMessage> noAddressFoundException(EmployeeNotFound employeeNotFound) {
		return new ResponseEntity<>(new ResponseMessage(true,employeeNotFound.getMessage(),null),
				HttpStatus.BAD_REQUEST);
	}

//	@ExceptionHandler(value = StaffManagementInfoNotFoundException.class)
//	public ResponseEntity<ExceptionResponse> supplierExceptionHandler(StaffManagementInfoNotFoundException exception) {
//		return new ResponseEntity<>(new ExceptionResponse(true, exception.getMessage(), null), HttpStatus.BAD_REQUEST);
//	}
//
//	@ExceptionHandler(value = StaffListEmptyException.class)
//	public ResponseEntity<ExceptionResponse> supplierExceptionHandler(StaffListEmptyException exception) {
//		return new ResponseEntity<>(new ExceptionResponse(true, exception.getMessage(), null), HttpStatus.BAD_REQUEST);
//	}
//
//	@ExceptionHandler(value = StaffManagementException.class)
//	public ResponseEntity<ExceptionResponse> supplierExceptionHandler(StaffManagementException exception) {
//		return new ResponseEntity<>(new ExceptionResponse(true, exception.getMessage(), null), HttpStatus.BAD_REQUEST);
//	}
//
//	@ExceptionHandler(value = CouponNotCreatedException.class)
//	public ResponseEntity<ExceptionResponse> handleException(CouponNotCreatedException exception) {
//		return new ResponseEntity<>(new ExceptionResponse(true, exception.getMessage(), null), HttpStatus.BAD_REQUEST);
//	}
//
//	@ExceptionHandler(value = InvalidCouponCodeException.class)
//	public ResponseEntity<ExceptionResponse> handleException(InvalidCouponCodeException exception) {
//		return new ResponseEntity<>(new ExceptionResponse(true, exception.getMessage(), null), HttpStatus.BAD_REQUEST);
//	}
//
//	@ExceptionHandler(value = SupplierMobileNumberRegisteredException.class)
//	public ResponseEntity<ExceptionResponse> handleException(SupplierMobileNumberRegisteredException exception) {
//		return new ResponseEntity<>(new ExceptionResponse(true, exception.getMessage(), null), HttpStatus.BAD_REQUEST);
//	}
//
//	@ExceptionHandler(value = PasswordNotMatchedException.class)
//	public ResponseEntity<ExceptionResponse> handleException(PasswordNotMatchedException exception) {
//		return new ResponseEntity<>(new ExceptionResponse(true, exception.getMessage(), null), HttpStatus.BAD_REQUEST);
//
//	}
//
//	@ExceptionHandler(value = SupplierException.class)
//	public ResponseEntity<ExceptionResponse> handleException(SupplierException exception) {
//		return new ResponseEntity<>(new ExceptionResponse(true, exception.getMessage(), null), HttpStatus.BAD_REQUEST);
//	}
//
//	@ExceptionHandler(value = NoBankDetailsFoundException.class)
//	public ResponseEntity<ExceptionResponse> supplierExceptionHandler(NoBankDetailsFoundException exception) {
//		return new ResponseEntity<>(new ExceptionResponse(true, exception.getMessage(), null), HttpStatus.BAD_REQUEST);
//	}
//
//	@ExceptionHandler(value = InvalidBankDetailsException.class)
//	public ResponseEntity<ExceptionResponse> supplierExceptionHandler(InvalidBankDetailsException exception) {
//		return new ResponseEntity<>(new ExceptionResponse(true, exception.getMessage(), null), HttpStatus.BAD_REQUEST);
//	}
//
//	@ExceptionHandler(value = InvalidOtpException.class)
//	public ResponseEntity<ExceptionResponse> handleException(InvalidOtpException exception) {
//		return new ResponseEntity<>(new ExceptionResponse(true, exception.getMessage(), null), HttpStatus.BAD_REQUEST);
//	}
//
//	@ExceptionHandler(value = ResetPasswordFailedException.class)
//	public ResponseEntity<ExceptionResponse> handleException(ResetPasswordFailedException exception) {
//		return new ResponseEntity<>(new ExceptionResponse(true, exception.getMessage(), null), HttpStatus.BAD_REQUEST);
//	}
//
//	@ExceptionHandler(value = SupplierNotFoundException.class)
//	public ResponseEntity<ExceptionResponse> handleException(SupplierNotFoundException exception) {
//		return new ResponseEntity<>(new ExceptionResponse(true, exception.getMessage(), null), HttpStatus.BAD_REQUEST);
//	}
//
//	@ExceptionHandler(value = CouponNotFoundException.class)
//	public ResponseEntity<ExceptionResponse> handleException(CouponNotFoundException exception) {
//		return new ResponseEntity<>(new ExceptionResponse(true, exception.getMessage(), null), HttpStatus.BAD_REQUEST);
//	}
//
//	@ExceptionHandler(value = RoleException.class)
//	public ResponseEntity<ExceptionResponse> handleException(RoleException exception) {
//		return new ResponseEntity<>(new ExceptionResponse(true, exception.getMessage(), null), HttpStatus.BAD_REQUEST);
//	}
//
//	@ExceptionHandler(value = SupplierIdNotFoundException.class)
//	public ResponseEntity<ExceptionResponse> handleException(SupplierIdNotFoundException exception) {
//		return new ResponseEntity<>(new ExceptionResponse(true, exception.getMessage(), null), HttpStatus.BAD_REQUEST);
//	}
//
//	@ExceptionHandler(value = UserIdNotFoundException.class)
//	public ResponseEntity<ExceptionResponse> exceptionHandler(UserIdNotFoundException exception) {
//		return new ResponseEntity<>(new ExceptionResponse(true, exception.getMessage(), null), HttpStatus.BAD_REQUEST);
//	}
//
//	@ExceptionHandler(value = SellerReviewNotFoundException.class)
//	public ResponseEntity<ExceptionResponse> exceptionHandler(SellerReviewNotFoundException exception) {
//		return new ResponseEntity<>(new ExceptionResponse(true, exception.getMessage(), null), HttpStatus.BAD_REQUEST);
//	}
//
//	@ExceptionHandler(value = InactiveSupplierStoreException.class)
//	public ResponseEntity<ExceptionResponse> exceptionHandler(InactiveSupplierStoreException exception) {
//		return new ResponseEntity<>(new ExceptionResponse(true, exception.getMessage(), null), HttpStatus.BAD_REQUEST);
//	}
//
//	@ExceptionHandler(value = DuplicateCouponCodeException.class)
//	public ResponseEntity<ExceptionResponse> exceptionHandler(DuplicateCouponCodeException exception) {
//		return new ResponseEntity<>(new ExceptionResponse(true, exception.getMessage(), null), HttpStatus.BAD_REQUEST);
//	}
//
//	@ExceptionHandler(value = SendFailedException.class)
//	public ResponseEntity<ExceptionResponse> exceptionHandler(SendFailedException exception) {
//		return new ResponseEntity<>(new ExceptionResponse(true, "Failed To Send Mail", null), HttpStatus.BAD_REQUEST);
//	}
}

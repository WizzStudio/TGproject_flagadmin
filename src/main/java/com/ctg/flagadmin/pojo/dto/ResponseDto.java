package com.ctg.flagadmin.pojo.dto;

import com.ctg.flagadmin.enums.ResponseStatusEnum;

public class ResponseDto {

    /**
     * 返回状态码
     */
    private int status;

    /**
     * 返回信息
     */
    private String message;

    /**
     * 返回数据
     */
    private Object data;


    private ResponseDto() {
    }

    private ResponseDto(int status, String message) {
        this.status = status;
        this.message = message;
    }

    private ResponseDto(int status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    /**
     * 成功时，返回的对象,只有状态码
     * @return ResponseDto
     */
    public static ResponseDto succeed() {
        return new ResponseDto(ResponseStatusEnum.SUCCEED.getValue(), null);
    }

    /**
     * 成功时，返回的对象,只有信息，没有数据
     * @param message  返回的提示信息
     * @return ResponseDto
     */
    public static ResponseDto succeed(String message) {
        return new ResponseDto(ResponseStatusEnum.SUCCEED.getValue(), message);
    }

    /**
     * 成功时，返回的对象,含有信息和数据
     * @param message 返回的提示信息
     * @param data 返回的数据
     * @return ResponseDto
     */
    public static ResponseDto succeed(String message, Object data) {
        return new ResponseDto(ResponseStatusEnum.SUCCEED.getValue(), message, data);
    }

    /**
     * 失败时，返回的对象，只含有状态码
     * @return ResponseDto
     */
    public static ResponseDto failed() {
        return new ResponseDto(ResponseStatusEnum.FAILED.getValue(), null);
    }

    /**
     * 失败时，返回的对象，含有状态码和信息
     * @param message 返回的提示信息
     * @return ResponseDto
     */
    public static ResponseDto failed(String message) {
        return new ResponseDto(ResponseStatusEnum.FAILED.getValue(), message);
    }

    /**
     * 失败时，返回的对象，含有信息和数据
     * @param message 返回的提示信息
     * @param data 返回的数据
     * @return ResponseDto
     */
    public static ResponseDto failed(String message, Object data) {
        return new ResponseDto(ResponseStatusEnum.FAILED.getValue(), message, data);
    }


    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResponseDto{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}

package com.witenconsulting.cqrs.command.domain.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class BaseResponse<T> {
    String message;
    Integer status;
    T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public BaseResponse(T data) {
        this.message = "OK";
        this.status = HttpStatus.OK.value();
        this.data = data;
    }

}
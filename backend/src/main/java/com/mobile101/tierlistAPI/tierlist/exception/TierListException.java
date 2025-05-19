package com.mobile101.tierlistAPI.tierlist.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.mobile101.tierlistAPI.exception.BaseException;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class TierListException extends BaseException{

	protected TierListException(String code, HttpStatus status) {
		super("tierlist." + code, status);
		
	}
	public static TierListException emptyStudent() {
		return new TierListException("findTierlist.notFound", HttpStatus.BAD_REQUEST);
	}
	
}

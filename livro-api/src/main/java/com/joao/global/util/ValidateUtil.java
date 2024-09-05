package com.joao.global.util;

import static java.lang.Boolean.TRUE;
import static java.util.Objects.isNull;

import java.util.List;
import java.util.NoSuchElementException;

public class ValidateUtil {

	public static void checkIsNull(Object obj, String message) {
		if (isNull(obj)) {
			throw new NoSuchElementException(message);
		}
	}
	
	public static void checkExist(Boolean condition, String message) {
		if (TRUE.equals(condition)) {
			throw new NoSuchElementException(message);
		}
	}
	
	public static <T> void checkListIsEmpty(List<T> listObj, String message) {
	    checkIsNull(listObj, message);
	    if (listObj.isEmpty()) {
	        throw new NoSuchElementException(message);
	    }
	}
}

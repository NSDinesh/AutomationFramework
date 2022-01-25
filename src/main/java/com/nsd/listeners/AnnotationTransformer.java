package com.nsd.listeners;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

public class AnnotationTransformer implements IAnnotationTransformer{

	/**
	 * This can be used to change the behavior of Test methods at Runtime
	 */
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {

	}

}

package com.zjw.springdemo.mvc.validation;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.xml.validation.Validator;

public class CourseCodeConstriantValidator implements ConstraintValidator<CourseCode, String> {


    private String coursePrefix;

    @Override
    public void initialize(CourseCode theCourseCode) {
        coursePrefix = theCourseCode.value();
    }


    @Override
    public boolean isValid(String theCode, ConstraintValidatorContext constraintValidatorContext) {


        boolean result;
        if(theCode != null){
            result = theCode.startsWith(coursePrefix);
        }else{
            result = true;
        }

        return result;
    }



}

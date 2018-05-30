package com.akshay.coreBasics;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternLikeMatchingDemo {
	public static void main(String args[]) {
		printRegex1();
	}

	
	private static void printRegex1() {
			String template = "/SpliceInfoSection/SegmentationDescriptor/SegmentationUpid[@segmentationUpidType = {id}]";
		    String withValues = "/SpliceInfoSection/SegmentationDescriptor/SegmentationUpid[@segmentationUpidType = 8]";
		    String patternFromTemplate = template.replaceAll("\\]", "\\\\]").replaceAll("\\[", "\\\\[");  
		    patternFromTemplate = patternFromTemplate.replace("{id}", "(.*)");
		    Pattern p = Pattern.compile(patternFromTemplate);
		    Matcher m = p.matcher(withValues);
		    if (m.matches()) {
		        System.out.println("{id}   = "+m.group(1));
		    } 
		    
		    
		    template = "/SpliceInfoSection/SegmentationDescriptor[@segmentationTypeId = {id1} or @segmentationTypeId = {id2}]";
		    withValues = "/SpliceInfoSection/SegmentationDescriptor[@segmentationTypeId = 16 or @segmentationTypeId = 23]";
		    patternFromTemplate = template.replaceAll("\\]", "\\\\]").replaceAll("\\[", "\\\\[");  
		    patternFromTemplate = patternFromTemplate.replace("{id1}", "(.*)").replace("{id2}", "(.*)");
		    p = Pattern.compile(patternFromTemplate);
		    m = p.matcher(withValues);
		    if (m.matches()) {
		        System.out.println("{id1}   = "+m.group(1));
		        System.out.println("{id2}   = "+m.group(1));

		    } 
	}
}
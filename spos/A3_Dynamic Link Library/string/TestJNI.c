#include<jni.h>
#include<stdio.h>
#include<string.h>
#include "TestJNI.h"

JNIEXPORT void JNICALL Java_TestJNI_reverseString(JNIEnv *env , jobject obj){

	char str[20] = "Hello World";
	int n = strlen(str);
	
	char reversedStr[20];
	
	int j=0;
	for(int i=n-1;i>=0;i--){
	    reversedStr[j] = str[i];
	    j++; 
	}
	
	reversedStr[n]= '\0';
	
	printf("Original String: %s\n" ,str);
	printf("Reversed String: %s\n" , reversedStr);
	
}

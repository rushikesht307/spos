#include <jni.h>
#include <stdio.h>
#include "TestJNI.h"

JNIEXPORT void JNICALL Java_TestJNI_addMatrices(JNIEnv *env, jobject obj) {
    // Define matrices A and B
    int matrixA[3][3] = {
        {1, 2, 3},
        {4, 5, 6},
        {7, 8, 9}
    };

    int matrixB[3][3] = {
        {9, 8, 7},
        {6, 5, 4},
        {3, 2, 1}
    };

    // Matrix for storing the result
    int result[3][3];

    // Perform matrix addition
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            result[i][j] = matrixA[i][j] + matrixB[i][j];
        }
    }

    // Print matrices
    printf("Matrix A:\n");
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            printf("%d ", matrixA[i][j]);
        }
        printf("\n");
    }

    printf("\nMatrix B:\n");
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            printf("%d ", matrixB[i][j]);
        }
        printf("\n");
    }

    // Print result matrix
    printf("\nResult Matrix:\n");
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            printf("%d ", result[i][j]);
        }
        printf("\n");
    }
}

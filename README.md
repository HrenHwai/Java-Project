## Overview 
This project implements an image-processing library in Java 

## Implemented Filters 
The following kernel filters are implemented:
- Indentity
- Gaussian blur
- Sharpen
- Laplacian
- Emboss
- Motion Blur

Each filter is implemented using a predifined convolution kernel
and applied independently to the red, green and blue channels of 
the image.

## Problem Description 
Kernel filters modify an image by replacing each pixel value with 
a weighted sum of its neigboring pixels. This operation is widely 
used in image processing for smoothing, sharpening, edge detection, 
and motion effects.

The goals of this project: 
- to implement kernel-based convolution from scratch
- handle image boundaries correctly
- manage numerical precision and pixel constraints

## Approach 
1. The kernel is centered on the pixel
2. Negbhoring pixel values are multiplied by the corresponding kernel weights
3. the weighted values are summed to compute a new pixel value
4. the operation is applied separately to each RGB channel

## Boundary Handling 
Modulo arithmetic is used: 
- pixels at the image edges wrap around to the opposite side 
- this ensures that every kernel access refers to a valid

## Numerical handling 
Rounding : Fractional RGB values are rounded up to nearest integer 
Clamping : RGB values are constrained to the range [0, 255] to prevent 
overflow and underflow. 


# Tools 
- Java
- 'Picture' data type (Princeton Java Standard Library)
- 'Color' data type ('java.awt.Color')

## Public API 
- 'identity (Picture picture)'
- 'gaussian (Picture picture)'
- 'sharpen (Picture picture)'
- 'lapacian (Picture picture)'
- 'emboss (Picuture picture)'
- 'motionBlur (Picture picuture)'

each method returns new image with the corresponding filter applied

## performance 
All filter operations run in time proportional to: 
(number of pixels) x (number of kernel elements)

## How to run
1. compile the Java files:
   javac KernelFilter.java

2. Run the test client:
   java KernelFilter

3. Load an image using Picture data type and apply desired filters 

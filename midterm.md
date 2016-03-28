####The program makes use of several classes and interfaces that belong to the Java API. Identify these classes and interfaces. For what purposes are they used in this program?
**Some Classes belonging to the Java API used in this program are:**
**GeneralPath-** Represents a geometric path constructed from straight lines and curves. Used to create the shape of a triangle.
**LinkedList-** The implementation of a linked list. Used to hold the list of triangles being shown.
**Color-** A class to represent colors. Shows the different colors when shading.
**Graphics-** An abstract class that allows the drawing of objects onto the container.
**Graphics2D-** An abstract extension of Graphics used to draw 2D objects. All drawings on this program uses Graphics 2D.
**AffineTransform-** Is a class that implements affine transformations using matrices. An affine transformation maintains collinearity. In this case, it is used to scale and translate the image so, that the axes start at -1 and extend to 1. The translation puts origin at the center instead of top left.
**JPanel-** Generic container to hold other swwing or AWT components. In this case, It holds the actual image that is being shaded.
**JFrame-** This is a top level container. In this case, it holds a container which in turn holds a JPanel.
**Container-** The container can be used to contain other AWT or swing components and in this case, it contains the JPanel that is being used for the shading.
**Some interfaces are:**
**List-** Linked list implements the list interface. This means certain methods can be expected of all LinkedLists as stated in the List interface.
**Shape-** Provides definitions for objects that are a geometric shape.

####The program uses recursion. Where? For what purpose?
Recursion is used in the function ``Subdivide`` to subdivide triangles further.

####The program defines a vector that specifies the direction to a source of light. Changing the x, y, and z elements of this vector will change the shading of the sphere. What is the name of this vector?
``illumination``

####The program defines a constant that specifies the fineness of the mesh of triangles that the program draws. What is the name of this constant?
``RECURSION_LIMIT``

####The program draws triangles that have different brightnesses but all have the same hue. What are the names of the constants whose values you must change to get a different hue?
``RED, GREEN, BLUE``

####The program computes the brightness of each triangle with operations on vectors. What are these operations?
``dotProduct(v)``

####Look at the toString() method in the Vector3D class. It calls the format() method of the String class. This method is probably unfamiliar to you. By experimentation and by reading on the Web learn how it works, then explain as clearly and concisely as you can.
The format() works a lot like printf in most other languages. The first argument is the string to be formatted with certain placeholders that show what type of data will be put into that place. All other arguments replace the placeholders with the argument provided. The first argument goes to eh zeroth placeholder, the second to the first and so on. For example:
``String.format("%s is %d years old, er, young", "Al", 45) );`` will return ``"Al is 45 years old, er, young"``
The %s signifies string %d signifies decimal value. Format is used mostly to have to avoid string concatenation for outputting.

####Compose a UML class diagram to describe the Vector3D class.
https://github.com/OrghoN/CSC-144/blob/master/shadingDiagram/UMLClassDiagram.png

####Complete the unit tests for the methods of the Vector3D class by editing Vector3DTest.java.
https://github.com/OrghoN/CSC-144/blob/master/shading/test/shading/Vector3DTest.java

####(Challenge problem) Modify the program so that it draws a different kind of curved surface.
https://github.com/OrghoN/CSC-144/blob/master/shading/src/shading/ShadingPanel.java

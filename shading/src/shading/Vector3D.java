package shading;

public class Vector3D {

    private final double x;
    private final double y;
    private final double z;

    public Vector3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    } // Vector3D( double, double, double )

    public double getX() {
        return this.x;
    } // getX()

    public double getY() {
        return this.y;
    } // getY()

    public double getZ() {
        return this.z;
    } // getZ()

    public Vector3D add(Vector3D v) {
        double xCoord = this.x + v.x;
        double yCoord = this.y + v.y;
        double zCoord = this.z + v.z;

        return new Vector3D(xCoord, yCoord, zCoord);
    } // add( Vector3D )

    public Vector3D subtract(Vector3D v) {
        double xCoord = this.x - v.x;
        double yCoord = this.y - v.y;
        double zCoord = this.z - v.z;

        return new Vector3D(xCoord, yCoord, zCoord);
    } // subtract( Vector3D )

    public Vector3D scale( double s ) {
        return new Vector3D( s * this.x, s * this.y, s * this.z );
    } // scale( double )
    
    public double dot(Vector3D v) {
        return this.x * v.x + this.y * v.y + this.z * v.z;
    } // dot( Vector3D )
    
    public double magnitude() {
        return Math.sqrt(this.dot( this ));
    } // magnitude()
    
    public Vector3D normalize() {
        double length = this.magnitude();
        return this.scale( 1.0/length );
    } // normalize()
    
    public Vector3D cross( Vector3D v ) {
        double xCoord = this.y * v.z - this.z * v.y;
        double yCoord = this.z * v.x - this.x * v.z;
        double zCoord = this.x * v.y - this.y * v.x;
        
        return new Vector3D( xCoord, yCoord, zCoord );
    } // cross( Vector3D )
    
    @Override
    public String toString() {
        return String.format( "(%6.2f, %6.2f, %6.2f)", this.x, this.y, this.z );
    } // toString()
} // Vector3D

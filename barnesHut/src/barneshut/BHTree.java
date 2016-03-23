/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barneshut;

/**
 *
 * @author orgho
 */
public class BHTree {

    private final double THETA = 0.5; // value for Barnes Hut Threshhold

    private Body body;
    private Quadrant quad;
    private BHTree NW;
    private BHTree NE;
    private BHTree SW;
    private BHTree SE;

    public BHTree(Quadrant q) {
        this.quad = q;
        this.body = null;
        this.NW = null;
        this.SW = null;
        this.NE = null;
        this.SE = null;

    }

    public Boolean isExternal(BHTree tree) {
        return (tree.getNW() == null && tree.getNE() == null && tree.getSW() == null && tree.getSE() == null);
    }

    public void putBody(Body b) {
        if (b.in(quad.NW())) {
            NW.insert(b);
        } else if (b.in(quad.NE())) {
            NE.insert(b);
        } else if (b.in(quad.SE())) {
            SE.insert(b);
        } else if (b.in(quad.SW())) {
            SW.insert(b);
        }
    }

    public void insert(Body b) {
        if (this.body == null) {
            this.body = b;
            return;
        }

        if (!this.isExternal(this)) {
            this.body = this.body.add(b);
            this.putBody(b);
        } else {
            this.NW = new BHTree(this.quad.NW());
            this.NE = new BHTree(this.quad.NE());
            this.SE = new BHTree(this.quad.SE());
            this.SW = new BHTree(this.quad.SW());

            //recursively insert both bodies
            putBody(this.body);
            putBody(b);

            //update center of mass and mass
            this.body = this.body.add(b);
        }
    }

    public void updateForce(Body b) {
        if (this.body == null || b.equals(this.body)) {
            return;
        }

        if (this.isExternal(this)) {
            b.addForce(this.body);
        } else {
            double s = this.quad.getLength();
            double d = this.body.distanceTo(b);

            if (s / d < THETA) {
                b.addForce(this.body);
            } else {
                NW.updateForce(b);
                NE.updateForce(b);
                SW.updateForce(b);
                SE.updateForce(b);
            }
        }

    }

    @Override
    public String toString() {
        if (NE != null || NW != null || SW != null || SE != null) {
            return "*" + this.body + "\n" + this.NW + this.NE + this.SW + this.SE;
        } else {
            return " " + this.body + "\n";
        }
    }

    /**
     * @return the body
     */
    public Body getBody() {
        return body;
    }

    /**
     * @param body the body to set
     */
    public void setBody(Body body) {
        this.body = body;
    }

    /**
     * @return the quad
     */
    public Quadrant getQuad() {
        return quad;
    }

    /**
     * @param quad the quad to set
     */
    public void setQuad(Quadrant quad) {
        this.quad = quad;
    }

    /**
     * @return the NW
     */
    public BHTree getNW() {
        return NW;
    }

    /**
     * @param NW the NW to set
     */
    public void setNW(BHTree NW) {
        this.NW = NW;
    }

    /**
     * @return the NE
     */
    public BHTree getNE() {
        return NE;
    }

    /**
     * @param NE the NE to set
     */
    public void setNE(BHTree NE) {
        this.NE = NE;
    }

    /**
     * @return the SW
     */
    public BHTree getSW() {
        return SW;
    }

    /**
     * @param SW the SW to set
     */
    public void setSW(BHTree SW) {
        this.SW = SW;
    }

    /**
     * @return the SE
     */
    public BHTree getSE() {
        return SE;
    }

    /**
     * @param SE the SE to set
     */
    public void setSE(BHTree SE) {
        this.SE = SE;
    }

}

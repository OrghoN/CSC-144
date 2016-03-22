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

    public void insert(Body b) {
        if (this.body == null) {
            this.body = b;
        }

    }

    public void updateForce(Body b) {

    }

    @Override
    public String toString() {
        return "";
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

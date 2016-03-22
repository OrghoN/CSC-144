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
        } else if (this.isExternal(this) == false) {
            this.body = b.add(this.body, b);

            Quadrant northWest = this.quad.NW();
            if (b.in(northWest)) {
                if (this.NW == null) {
                    this.NW = new BHTree(northWest);
                }
                NW.insert(b);
            } else {
                Quadrant northEast = this.quad.NE();
                if (b.in(northEast)) {
                    if (this.NE == null) {
                        this.NE = new BHTree(northEast);
                    }
                    NE.insert(b);
                } else {
                    Quadrant southEast = this.quad.SE();
                    if (b.in(southEast)) {
                        if (this.SE == null) {
                            this.SE = new BHTree(southEast);
                        }
                        SE.insert(b);
                    } else {
                        Quadrant southWest = this.quad.SW();
                        if (b.in(southWest)) {
                            if (this.SW == null) {
                                this.SW = new BHTree(southWest);
                            }
                            SW.insert(b);
                        }
                    }
                }
            }

        } else if (this.isExternal(this)) {
            Body c = this.body;

            Quadrant northWest = this.quad.NW();
            if (c.in(northWest)) {
                if (this.NW == null) {
                    this.NW = new BHTree(northWest);
                }
                NW.insert(c);
            } else {
                Quadrant northEast = this.quad.NE();
                if (c.in(northEast)) {
                    if (this.NE == null) {
                        this.NE = new BHTree(northEast);
                    }
                    NE.insert(c);
                } else {
                    Quadrant southWest = this.quad.SW();
                    if (c.in(southWest)) {
                        if (this.SW == null) {
                            this.SW = new BHTree(southWest);
                        }
                        SW.insert(c);
                    } else {
                        Quadrant southEast = this.quad.SE();
                        if (c.in(southEast)) {
                            if (this.SE == null) {
                                this.SE = new BHTree(southEast);
                            }
                            SE.insert(c);
                        }
                    }
                }
            }

            this.insert(b);
        }

    }

    public void updateForce(Body b) {
        if (this.isExternal(this)) {
            if (this.body != b) {
                b.addForce(this.body);
            }
        } else if (this.quad.getLength() / this.body.distanceTo(b) < 2) {
            b.addForce(this.body);
        } else {
            if (this.NW != null) {
                this.NW.updateForce(b);
            }
            if (this.NE != null) {
                this.NE.updateForce(b);
            }
            if (this.SW != null) {
                this.SW.updateForce(b);
            }
            if (this.SE != null) {
                this.SE.updateForce(b);
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

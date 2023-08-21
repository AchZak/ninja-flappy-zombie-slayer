package entiteiten;

public interface CollisionDetection {
    void collidesWith(Vijand var1);

    void collidesWith(Wapen var1);

    void collidesWith(Toren var1);
}
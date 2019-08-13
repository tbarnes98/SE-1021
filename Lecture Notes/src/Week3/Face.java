package Week3;

public interface Face {
    //You may only have constant variables in an interface, unlike abstract classes
    double NUM_EYES = 2;
    //Interface methods will always be public and abstract so it's assumed. Unlike abstract
    //  classes which can have both fully and non-fully implemented methods, interfaces do not
    void nose();
    void mouth();
}

package de.lukaskoerfer.simplepnml;

/**
 * Marks all elements that serve as an annotation
 */
public interface Annotation {

    /**
     * Gets the graphical representation of this annotation element
     * @return
     */
    AnnotationGraphics getGraphics();

    /**
     * Sets the graphical representation of this annotation element
     * @param graphics
     */
    void setGraphics(AnnotationGraphics graphics);

}

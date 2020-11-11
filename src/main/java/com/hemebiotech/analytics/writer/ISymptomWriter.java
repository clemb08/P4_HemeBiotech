package com.hemebiotech.analytics.writer;

/**
 * Anything that will write symptom data in a source
 *
 * The implementation does not need to order the list but can
 * if needed
 *
 */

public interface ISymptomWriter {
    /**
     * Write the List of symptoms in a new file
     */
    void writeSymptoms ();
}

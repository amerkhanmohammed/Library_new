
package com.library.system.exceptions;

public class SectionNotFoundException extends RuntimeException {
    public SectionNotFoundException() {
        super("Library section not found");
    }
}

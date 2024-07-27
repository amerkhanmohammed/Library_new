
package com.library.system.exceptions;

public class ItemNotFoundException extends RuntimeException {
    public ItemNotFoundException() {
        super("Item not found in the library");
    }
}

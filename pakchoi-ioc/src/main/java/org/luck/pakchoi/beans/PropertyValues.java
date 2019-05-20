package org.luck.pakchoi.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liukai
 * @date 2019-05-05
 */
public class PropertyValues {

    private final List<PropertyValue> propertyValueList = new ArrayList<>();

    public PropertyValues() {
    }

    public void addPropertyValue(PropertyValue pv) {
        this.propertyValueList.add(pv);
    }

    public List<PropertyValue> getPropertyValues() {
        return this.propertyValueList;
    }
}

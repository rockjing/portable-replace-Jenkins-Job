package Umu360.model;

/**
 * @author juven
 */
public class Replace
{
  private final String key;

  private final String xpath;

  private String value;

  private boolean isReplaced = false;

  private boolean valueChanged = false;


  public Replace(String key, String xpath, String value)
  {
    this.key = key;
    this.xpath = xpath;
    this.value = value;
  }

  public String getKey()
  {

    return key ==null? getXpath() : key;
    //return key;
  }

  public String getValue()
  {
    return value;
  }

  public void setValue(String value)
  {
    this.value = value;
  }

  public String getXpath()
  {
    return xpath;
  }

  //
  //add by Rock, show replaced state
  //
  public boolean getIsReplaced()
  {
    return this.isReplaced;
  }

  //
  //add by Rock, set replaced state
  //
  public void setIsReplaced(boolean isRep)
  {
    this.isReplaced = isRep;
  }


  //
  //add by Rock, to see value changed?
  //
  public boolean getValueChanged()
  {
    return this.valueChanged;
  }

  //
  //add by Rock, to see value changed?
  //
  public boolean checkValueChanged(String oldValue)
  {
    String oldValue2 = oldValue==null?"": oldValue.trim();
    return !oldValue2.equals(this.getValue());

  }

  //
  //add by Rock, set value changed
  //
  public void setValueChanged(boolean valueChanged)
  {
    this.valueChanged = valueChanged;
  }


  @Override
  public boolean equals(Object o)
  {
    if (this == o) return true;
    if (!(o instanceof Replace)) return false;

    Replace replace = (Replace) o;

    if (key != null ? !key.equals(replace.key) : replace.key != null) return false;
    if (value != null ? !value.equals(replace.value) : replace.value != null) return false;
    if (xpath != null ? !xpath.equals(replace.xpath) : replace.xpath != null) return false;

    return true;
  }

  @Override
  public int hashCode()
  {
    int result = key != null ? key.hashCode() : 0;
    result = 31 * result + (xpath != null ? xpath.hashCode() : 0);
    result = 31 * result + (value != null ? value.hashCode() : 0);
    return result;
  }
}

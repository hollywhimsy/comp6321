package frontEnd;

/**
* frontEnd/FrontEndHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from D:/Progs/Java-Progs/comp6231/src/frontEnd/FrontEnd.idl
* Sunday, July 15, 2018 9:35:29 PM EDT
*/

public final class FrontEndHolder implements org.omg.CORBA.portable.Streamable
{
  public frontEnd.FrontEnd value = null;

  public FrontEndHolder ()
  {
  }

  public FrontEndHolder (frontEnd.FrontEnd initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = frontEnd.FrontEndHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    frontEnd.FrontEndHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return frontEnd.FrontEndHelper.type ();
  }

}

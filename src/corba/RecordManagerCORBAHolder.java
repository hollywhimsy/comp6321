package corba;

/**
* corba/RecordManagerCORBAHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from D:/Progs/Java-Progs/comp6231/src/corba/RecordManager.idl
* Friday, June 8, 2018 3:57:02 AM EDT
*/

public final class RecordManagerCORBAHolder implements org.omg.CORBA.portable.Streamable
{
  public corba.RecordManagerCORBA value = null;

  public RecordManagerCORBAHolder ()
  {
  }

  public RecordManagerCORBAHolder (corba.RecordManagerCORBA initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = corba.RecordManagerCORBAHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    corba.RecordManagerCORBAHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return corba.RecordManagerCORBAHelper.type ();
  }

}

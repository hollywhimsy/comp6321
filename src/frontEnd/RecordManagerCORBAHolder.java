package frontEnd;

/**
* corba/RecordManagerCORBAHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from D:/Progs/Java-Progs/comp6231/src/corba/RecordManagerCORBA.idl
* Thursday, June 14, 2018 9:28:07 AM EDT
*/

public final class RecordManagerCORBAHolder implements org.omg.CORBA.portable.Streamable
{
  public frontEnd.RecordManagerCORBA value = null;

  public RecordManagerCORBAHolder ()
  {
  }

  public RecordManagerCORBAHolder (frontEnd.RecordManagerCORBA initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = frontEnd.RecordManagerCORBAHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    frontEnd.RecordManagerCORBAHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return frontEnd.RecordManagerCORBAHelper.type ();
  }

}
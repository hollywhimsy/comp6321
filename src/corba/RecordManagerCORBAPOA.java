package corba;


/**
* corba/RecordManagerCORBAPOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from D:/Progs/Java-Progs/comp6231/src/corba/RecordManager.idl
* Friday, June 8, 2018 3:40:42 AM EDT
*/

public abstract class RecordManagerCORBAPOA extends org.omg.PortableServer.Servant
 implements corba.RecordManagerCORBAOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("createTRecord", new java.lang.Integer (0));
    _methods.put ("createSRecord", new java.lang.Integer (1));
    _methods.put ("getRecordCounts", new java.lang.Integer (2));
    _methods.put ("getLocalRecordsCount", new java.lang.Integer (3));
    _methods.put ("editRecord", new java.lang.Integer (4));
    _methods.put ("recordExist", new java.lang.Integer (5));
    _methods.put ("shutdown", new java.lang.Integer (6));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    java.lang.Integer __method = (java.lang.Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {
       case 0:  // corba/RecordManagerCORBA/createTRecord
       {
         String firstName = in.read_string ();
         String lastName = in.read_string ();
         String address = in.read_string ();
         int phoneNumber = in.read_long ();
         org.omg.CORBA.Object specialization = org.omg.CORBA.ObjectHelper.read (in);
         String location = in.read_string ();
         String callerId = in.read_string ();
         boolean $result = false;
         $result = this.createTRecord (firstName, lastName, address, phoneNumber, specialization, location, callerId);
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       case 1:  // corba/RecordManagerCORBA/createSRecord
       {
         String firstName = in.read_string ();
         String lastName = in.read_string ();
         org.omg.CORBA.Object coursesRegistred = org.omg.CORBA.ObjectHelper.read (in);
         boolean status = in.read_boolean ();
         String statusDate = in.read_string ();
         String callerId = in.read_string ();
         boolean $result = false;
         $result = this.createSRecord (firstName, lastName, coursesRegistred, status, statusDate, callerId);
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       case 2:  // corba/RecordManagerCORBA/getRecordCounts
       {
         String callerId = in.read_string ();
         String $result = null;
         $result = this.getRecordCounts (callerId);
         out = $rh.createReply();
         out.write_string ($result);
         break;
       }

       case 3:  // corba/RecordManagerCORBA/getLocalRecordsCount
       {
         String callerId = in.read_string ();
         int $result = (int)0;
         $result = this.getLocalRecordsCount (callerId);
         out = $rh.createReply();
         out.write_long ($result);
         break;
       }

       case 4:  // corba/RecordManagerCORBA/editRecord
       {
         String recordID = in.read_string ();
         String fieldName = in.read_string ();
         org.omg.CORBA.Object newValue = org.omg.CORBA.ObjectHelper.read (in);
         String callerId = in.read_string ();
         boolean $result = false;
         $result = this.editRecord (recordID, fieldName, newValue, callerId);
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       case 5:  // corba/RecordManagerCORBA/recordExist
       {
         String recordId = in.read_string ();
         boolean $result = false;
         $result = this.recordExist (recordId);
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       case 6:  // corba/RecordManagerCORBA/shutdown
       {
         this.shutdown ();
         out = $rh.createReply();
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:corba/RecordManagerCORBA:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public RecordManagerCORBA _this() 
  {
    return RecordManagerCORBAHelper.narrow(
    super._this_object());
  }

  public RecordManagerCORBA _this(org.omg.CORBA.ORB orb) 
  {
    return RecordManagerCORBAHelper.narrow(
    super._this_object(orb));
  }


} // class RecordManagerCORBAPOA

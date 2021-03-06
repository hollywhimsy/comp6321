package frontEnd;


/**
* frontEnd/FrontEndOperations.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from D:/Progs/Java-Progs/comp6231/src/frontEnd/FrontEnd.idl
* Sunday, July 15, 2018 9:35:29 PM EDT
*/

public interface FrontEndOperations 
{
  boolean createTRecord (String firstName, String lastName, String address, String phoneNumber, String specialization, String location, String managerId);
  boolean createSRecord (String firstName, String lastName, String coursesRegistred, boolean status, String statusDate, String managerId);
  String getRecordCounts (String managerId);
  boolean editRecord (String recordID, String fieldName, String newValue, String managerId);
  boolean recordExist (String recordId, String managerId);
  boolean transferRecord (String managerId, String recordId, String remoteCenterServerName);
  void shutdown ();
} // interface FrontEndOperations

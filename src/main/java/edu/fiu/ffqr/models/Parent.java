package edu.fiu.ffqr.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import edu.fiu.ffqr.models.Clinician;

import com.fasterxml.jackson.annotation.JsonProperty;

@Document(collection="parents")
public class Parent extends User implements Serializable{

    @JsonProperty("assignedclinic")
    private String assignedclinic;
    @JsonProperty("assignedclinician")
    private String assignedclinician;    
    @JsonProperty("childrennames")
    private ArrayList<String> childrennames = new ArrayList<String>();
    @JsonProperty("prefix")
    private String prefix;

    // Used to track when parent last read recommend tab
    @JsonProperty("lastReadRecommend")
    private String lastReadRecommend; 



	public Parent() {}
	
    public Parent(String userId, String username, String userpassword, String usertype, 
            String firstname, String lastname, String assignedclinic,
            String assignedclinician, ArrayList<String> childrennames, boolean isactive, String prefix) {
        this.userId = userId;
		  this.username = username;
        this.userpassword = userpassword;
        this.usertype = usertype;
        this.firstname = firstname;
        this.lastname = lastname;
        this.assignedclinic = assignedclinic;
        this.assignedclinician = assignedclinician;
        this.childrennames = childrennames;
        this.isactive = isactive;
        this.prefix = prefix;
        // Set lastReadRecommend to empty string since a parent has not submitted recommend upon creation
        this.lastReadRecommend = "";
    }

    public String getAssignedclinic() {
        return this.assignedclinic;
    }
    public void setAssignedclinic(String assignedclinic) {
        this.assignedclinic = assignedclinic;
    }

    public String getAssignedclinician() {
        return this.assignedclinician;
    }
    public void setAssignedclinician(String assignedclinician) {
        this.assignedclinician = assignedclinician;
    }


    public ArrayList<String> getChildrenNames() {
        return this.childrennames;
    }

    public void setChildrenNames(ArrayList<String> childrennames) {
        this.childrennames = childrennames;
    }

    public String getPrefix() {
        return this.prefix;
    }
    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getUserId()
    {
      return this.userId;
    }

    public String getRecommendTime()
    {
      return this.lastReadRecommend;
    }

    public void setRecommendTime(String date)
    {
      this.lastReadRecommend = date;
    }
}

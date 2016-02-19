package rs.FB.service;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import rs.FB.dao.UserDAO;
import rs.FB.model.User;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ServiceUser {
	UserDAO ud=new UserDAO();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	//@Consumes(MediaType.APPLICATION_JSON)
	public ArrayList<User> getAllUser(){
		
		return ud.getAllUsers();
	}

	@GET
    @Path("/{UserID}")
	
    public User getUser(@PathParam("UserID") int UserID ){
		User user=new User();
		user=ud.getUserbyID(UserID);
	return user;
    }
	@POST
	
	public void insertUser(User user){
		ud.insertUser(user);
	}
	@DELETE
	@Path("/{userId}")
	public void deleteUser(@PathParam("userId") int userId){
		ud.deleteUserByID(userId);
	}
	@GET
    @Path("/{email}/{pass}")
    public User getUser(@PathParam("email") String email, @PathParam("pass") String password){
     
        return ud.getUser(email, password);
    }
	@PUT
	public void updateUserPass(User user){
		ud.updateUserPass(user);
	}
	
	
	
}

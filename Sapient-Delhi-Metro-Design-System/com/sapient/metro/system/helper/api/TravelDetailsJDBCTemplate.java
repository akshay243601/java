package com.sapient.metro.system.helper.api;

import java.util.List;

import javax.sql.DataSource;

import com.sapient.metro.system.SmartCard;

public class TravelDetailsJDBCTemplate implements TravelDetailsDAO {

	
	private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;
    
    @Override
	   public void setDataSource(DataSource dataSource) {
	      this.dataSource = dataSource;
	      this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	   }
	

	@Override
	public void create(String Cardname, int Balance, String Station) {
		// TODO Auto-generated method stub
		/*String SQL = "insert into TravelDetails (Cardname, Balance) values (?, ?)";
	      
	      jdbcTemplateObject.update( SQL, Cardname, Balance);
	      System.out.println("Created Record Name = " + Cardname + " Age = " + Balance);
	      return;*/
	}

	@Override
	public SmartCard getCard(String id) {
		String SQL = "select * from TravelDetails where id = ?";
	    //  SmartCard SmCard = jdbcTemplateObject.queryForObject(SQL, new Object[]{id}, new SmartCardMapper());
	      return SmCard;
	}

	@Override
	public List<SmartCard> listCardDetails() {
		// TODO Auto-generated method stub
		String SQL = "select * from TravelDetails";
	     // List <SmartCard> SmCard = jdbcTemplateObject.query(SQL,new SmartCardMapper());
	     // return SmCard;
	}



}

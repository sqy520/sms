package dao.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import dao.EmployeeDao;
import domain.Employee;
import domain.Information;

public class EmployeeDaoImpl implements EmployeeDao{
	private BufferedReader bf;
	private PrintWriter pw;
	private static final String employees="employees.txt";
	private static final String informations="informations.txt";
	
	@Override
	public boolean insertEmployee(Employee e) {
		try {
			pw=new PrintWriter(new OutputStreamWriter(new FileOutputStream(employees,true),"utf-8"));
			pw.println(e.show());
			pw.flush();
			return true;
		} catch (UnsupportedEncodingException | FileNotFoundException e1) {
			// TODO Auto-generated catch block
			return false;
		}finally {
			if(pw!=null)pw.close();
		}
	}
	
	@Override
	public List<Employee> selectAllEmployee() {
		List<Employee> list=new ArrayList<Employee>();
		try {
			bf=new BufferedReader(new InputStreamReader(new FileInputStream(employees), "utf-8"));
			String s="";
			while ((s=bf.readLine())!=null) {
				String[] splits = s.split("#");
				list.add(new Employee(Integer.parseInt(splits[0]), splits[1],splits[2],Integer.parseInt(splits[3])));
			}
			return list;
		} catch (UnsupportedEncodingException | FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {			
				try {
					if(bf!=null)bf.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return null;
	}

	@Override
	public Employee selectById(int id) {
		List<Employee> list=selectAllEmployee();
		for (Employee emp : list) {
			if (id==emp.getEmId()) {
				return emp;
			}
		}
		return null;
	}

	@Override
	public boolean deleteById(int id) {
		List<Employee> list=selectAllEmployee();
		Iterator<Employee> it=list.iterator();
		while (it.hasNext()) {
			Employee student=it.next();
			if (id==student.getEmId()) {
				it.remove();
				break;
			}
		}
		File file=new File(employees);
		if (file.exists()) {
			file.delete();
		}
		for (Employee s : list) {
			insertEmployee(s);
		}
		return true;
	}

	@Override
	public boolean changePswd(int id,String pswd) {
		Employee emp = selectById(id);
		emp.setEmPswd(pswd);
		deleteById(id);
		insertEmployee(emp);
		return true;
	}
	
	@Override
	public boolean insertInformation(Information info) {
		try {
			pw=new PrintWriter(new OutputStreamWriter(new FileOutputStream(informations,true),"utf-8"));
			pw.println(info.show());
			pw.flush();
			return true;
		} catch (UnsupportedEncodingException | FileNotFoundException e) {
			return false;
		}finally {
			if(pw!=null) pw.close();
		}
			
	}

	@Override
	public List<Information> selectAllInfomation(int emId) {
		List<Information> list=new ArrayList<Information>();
		try {
			bf=new BufferedReader(new InputStreamReader(new FileInputStream(informations), "utf-8"));
			String s="";
			while ((s=bf.readLine())!=null) {
				String[] splits = s.split("#");
				if (Integer.parseInt(splits[0])==emId) {
					list.add(new Information(Integer.parseInt(splits[0]), Integer.parseInt(splits[1]), splits[2], splits[3], Integer.parseInt(splits[4]), splits[5], splits[6]));
				}				
			}
			return list;
		} catch (UnsupportedEncodingException | FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {			
				try {
					if(bf!=null)bf.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return null;
	}

	@Override
	public Information seAppById(int infoId) {
		// TODO Auto-generated method stub
		return null;
	}

	

}

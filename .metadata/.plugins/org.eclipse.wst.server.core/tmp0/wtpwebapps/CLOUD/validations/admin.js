function validate()
{
	var id=document.myform.id.value;
	var name=document.myform.name.value;
	var password=document.myform.password.value;
	var mail=document.myform.mail.value;
	var mobile=document.myform.mobile.value;
	var address=document.myform.address.value;
	var city=document.myform.city.value;
	var atposition=mail.indexOf("@");  
	var dotposition=mail.lastIndexOf(".");
	
	if(id=="" || id==null)
		{
		alert("Enter your Office ID. ");
		return false;
		}
	if(name==null||name=="")
		{
		alert("Name can't be blank.");
		return false;
		}
	if(password==null||name=="")
		{
		alert("Password can't be blank.");
		return false;
		}
	if(password.length<5)
		{
		alert("Password must be more than 5 char.");
		return false;
		}
	if(mail==null||mail=="")
		{
		alert("Mail can't be blank.");
		return false;
		}
	  
	if (atposition<1 || dotposition<atposition+2 || dotposition+2>=mail.length){  
	  alert("Please enter a valid e-mail address.");  
	  return false;  
	  }  
	if(mobile==""||mobile==null)
		{
		alert("Enter your mobile number.");
		return false;
		}
	if(mobile.length<8||mobile.length>12)
		{
		alert("Enter your valid mobile number.");
		return false;
		}
	if(address==null||address=="")
		{
		alert("Address can't be blank");
		return false;
		}
	if(city==null||city=="")
		{
		alert("City name can't blank.");
		return false;
		}
	
	return true;
	}
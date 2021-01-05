window.onload = displayTicket("ALL");

function filterUpdate(){
	let filterSelect = document.getElementById("statusFilter").value;
	displayTicket(filterSelect);
}

function displayTicket(filter){
	document.getElementById("ticketTable").getElementsByTagName("tbody")[0].innerHTML = "";
	let xhttp = new XMLHttpRequest();
	
	let url = "http://localhost:8080/ExpenseReimbursement/api/manager/tickets";
	
	xhttp.open("GET", url);
	xhttp.send();
	
	xhttp.onreadystatechange = function(){
		if(xhttp.readyState == 4 && xhttp.status == 200){
			let item = JSON.parse(xhttp.responseText);
			console.log(item);
			item.forEach(element => {
				switch(filter){
					case "ALL":
						addRow(element);
						break;
					case "OPEN":
						if(element.status === "OPEN"){
							addRow(element);
						}
						break;
					case "DENIED":
						if(element.status === "DENIED"){
							addRow(element);
						}
						break;
					case "APPROVED":
						if(element.status === "APPROVED"){
							addRow(element);
						}
						break;
				}
			})
		}
	}
}

function updateTicket(element){
	let xhttp = new XMLHttpRequest();
	
	let url = "http://localhost:8080/ExpenseReimbursement/api/manager/tickets";
	
	xhttp.onreadystatechange = function(){
		if(xhttp.readyState === 4 && xhttp.status === 200){
			filterUpdate();
		}
	}
	let updateString = "";
	if(element.innerText === "Approve"){
		updateString = "APPROVED";
	}else{
		updateString = "DENIED";
	}
	
	xhttp.open("POST", url);
	
	let ticketInfo = {
		id: document.getElementById("ticketId").innerText,
		status: updateString
		}
	xhttp.send(JSON.stringify(ticketInfo));
}

function displayModal(element){
	document.getElementById("ticketId").innerText = element.id;
	document.getElementById("ticketType").innerText = element.type;
	document.getElementById("ticketDesc").innerText = element.description;
	document.getElementById("ticketAmount").innerText = "$" + element.amount.toFixed(2);
}


function addRow(element){
	let table = document.getElementById("ticketTable").getElementsByTagName("tbody")[0];
	let row = document.createElement("tr");
	let id = document.createElement("td");
	let empId = document.createElement("td");
	let type = document.createElement("td");
	let desc = document.createElement("td");
	let amount = document.createElement("td");
	let status = document.createElement("td");
	let time = document.createElement("td");
	
	id.innerHTML = element.id;
	empId.innerHTML = element.employeeId;
	type.innerHTML = element.type;
	desc.innerHTML = element.description;
	amount.innerHTML = "$ " + element.amount.toFixed(2);
	status.innerHTML = element.status;
	time.innerHTML = new Date(element.timeStamp).toLocaleString();
	
	row.appendChild(id);
	row.appendChild(empId);
	row.appendChild(type);
	row.appendChild(desc);
	row.appendChild(amount);
	row.appendChild(status);
	row.appendChild(time);
	if(element.status === "OPEN"){
		row.setAttribute("data-bs-toggle", "modal");
		row.setAttribute("data-bs-target", "#updateModal");
		row.onclick = function() {displayModal(element);}
	}
	table.appendChild(row);
}
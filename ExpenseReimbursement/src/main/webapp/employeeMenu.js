window.onload = displayTicket();


function resetForm(){
	let form = document.getElementsByTagName("form")[0];
	form.reset();
}

function displayTicket(){
	resetForm();
	
	let xhttp = new XMLHttpRequest()
	
	xhttp.onreadystatechange = function(){
		
		if(xhttp.readyState == 4 && xhttp.status == 200){
			let item = JSON.parse(xhttp.responseText);
			item.forEach(element => {
				let table = document.getElementById("ticketTable").getElementsByTagName("tbody")[0];
				let row = document.createElement("tr");
				let id = document.createElement("td");
				let type = document.createElement("td");
				let desc = document.createElement("td");
				let amount = document.createElement("td");
				let status = document.createElement("td");
				let time = document.createElement("td");
				
				id.innerHTML = element.id;
				type.innerHTML = element.type;
				desc.innerHTML = element.description;
				amount.innerHTML = "$ " + element.amount.toFixed(2);
				status.innerHTML = element.status;
				time.innerHTML = new Date(element.timeStamp).toLocaleString();
				
				row.appendChild(id);
				row.appendChild(type);
				row.appendChild(desc);
				row.appendChild(amount);
				row.appendChild(status);
				row.appendChild(time);
				
				table.appendChild(row);
			})
		}
	}
	let url = "http://localhost:8080/ExpenseReimbursement/api/employee/tickets";
	xhttp.open("GET", url);
	xhttp.send();
};

function submitTicket(){
	let xhttp = new XMLHttpRequest();
	let url = "http://localhost:8080/ExpenseReimbursement/api/employee/tickets";
	xhttp.open("POST", url);
	let ticket = {
		type: document.getElementById("type").value,
		amount: document.getElementById("amount").value,
		description: document.getElementById("description").value
	}
	xhttp.send(JSON.stringify(ticket));
	
	xhttp.onreadystatechange = function(){
		if(xhttp.readyState == 4 && xhttp.status == 200){
			document.getElementById("ticketTable").getElementsByTagName("tbody")[0].innerHTML = "";
			displayTicket();
		}
	}
}

function formatAmount(){
	let amount = document.getElementById("amount");
	amount.value = parseFloat(amount.value).toFixed(2);
}

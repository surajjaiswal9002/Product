package com.Target.Product.Nielsen.IMS;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;


enum IssueStatus{
	OPEN,
	IN_PROGRESS,
	RESOLVED
	
}

enum IssueType{
	PAYMENT_RELATED,
	ORDER_PROCESSING,
	ONBOARDING_ISSUES,
	SPF
}


class Issue{
	private String issueId;
	private String userEmail;
	private String descriptions;
	private IssueType issueType;
	private IssueStatus status;
	private LocalDateTime createAt;
	private LocalDateTime resolvedAt;
	private String assignedToAgent;
	
	public Issue(String issueId, String userEmail, String descriptions, IssueType issueType) {
		super();
		this.issueId = issueId;
		this.userEmail = userEmail;
		this.descriptions = descriptions;
		this.issueType = issueType;
		this.status = IssueStatus.OPEN;
		this.createAt = LocalDateTime.now();
	}

	public String getIssueId() {
		return issueId;
	}

	public void setIssueId(String issueId) {
		this.issueId = issueId;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getDescriptions() {
		return descriptions;
	}

	public void setDescriptions(String descriptions) {
		this.descriptions = descriptions;
	}

	public IssueType getIssueType() {
		return issueType;
	}

	public void setIssueType(IssueType issueType) {
		this.issueType = issueType;
	}

	public IssueStatus getStatus() {
		return status;
	}

	public void setStatus(IssueStatus status) {
		this.status = status;
	}

	public LocalDateTime getCreateAt() {
		return createAt;
	}

	public void setCreateAt(LocalDateTime createAt) {
		this.createAt = createAt;
	}

	public LocalDateTime getResolvedAt() {
		return resolvedAt;
	}

	public void setResolvedAt(LocalDateTime resolvedAt) {
		this.resolvedAt = resolvedAt;
	}

	public String getAssignedToAgent() {
		return assignedToAgent;
	}

	public void setAssignedToAgent(String assignedToAgent) {
		this.assignedToAgent = assignedToAgent;
	}
	
	public long getResolutionsTimeInMinutes() {
		if(resolvedAt != null && createAt != null) {
			return Duration.between(resolvedAt, createAt).toMinutes();
		}
		return -1;
	}

	@Override
	public String toString() {
		return "Issue [issueId=" + issueId + ", userEmail=" + userEmail + ", descriptions=" + descriptions
				+ ", issueType=" + issueType + ", status=" + status + ", createAt=" + createAt + ", resolvedAt="
				+ resolvedAt + ", assignedToAgent=" + assignedToAgent + "]";
	}

	public String getAssignedAgentId() {
		// TODO Auto-generated method stub
		return null;
	}
	
}


class Agent{
	private String agentId;
	private String agentName;
	private List<IssueType> specializations;
	private List<String> workHistory;
	private boolean isBusy;
	
	

	public Agent(String agentId, String agentName, List<IssueType> specializations) {
		;
		this.agentId = agentId;
		this.agentName = agentName;
		this.specializations = new ArrayList<IssueType>(specializations);
		this.workHistory = new ArrayList<String>();
		this.isBusy = false;
	}
	
	
	public String getAgentId() {
		return agentId;
	}

	public void setAgentId(String agentId) {
		this.agentId = agentId;
	}

	public String getAgentName() {
		return agentName;
	}

	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}

	public List<IssueType> getSpecializations() {
		return specializations;
	}

	public boolean setSpecializations(IssueType issueType) {
		return specializations.contains(issueType);
	}

	public List<String> getWorkHistory() {
		return workHistory;
	}

	public void setWorkHistory(List<String> workHistory) {
		this.workHistory = workHistory;
	}

	public boolean isBusy() {
		return isBusy;
	}

	public void setBusy(boolean isBusy) {
		this.isBusy = isBusy;
	}


	@Override
	public String toString() {
		return "Agent [agentId=" + agentId + ", agentName=" + agentName + ", specializations=" + specializations
				+ ", workHistory=" + workHistory + ", isBusy=" + isBusy + "]";
	}


	public void addToWorkHistory(String issueId) {
		// TODO Auto-generated method stub
		
	}
	
}



public class IncidentManagementSystem {
		private Map<String, Agent> agents;
		private Map<String, Issue> issues;
		private Map<IssueType, Queue<String>> issueQueue;
		
	
		
		public IncidentManagementSystem() {
			this.agents = new HashMap<String, Agent>();
			this.issues = new HashMap<String, Issue>();
			this.issueQueue = new HashMap<IssueType, Queue<String>>();
			
			for(IssueType type : IssueType.values()) {
				issueQueue.put(type, new LinkedList<String>());
			}
		}
		
		// add agent
		public void addAgent(String agentId, String name, List<IssueType> specializations) {
			if(agents.containsKey(agentId)) {
				throw new IllegalArgumentException(" Dublicate Entries. ");
			}
			
			if(specializations == null || specializations.isEmpty()) {
				throw new IllegalArgumentException(" Agents must have atLeast one specializations.");
			}
			
			Agent agent = new Agent(agentId, name, specializations);
			agents.put(agentId, agent);
			System.out.println(" Agent added : "+agent);
		}
		
		// View agent
		public void viewAgentWorkHistory(String agentId) {
			Agent agent = getAgent(agentId);
			List<String> history = agent.getWorkHistory();
			
			System.out.println(" \n    Work History Agent : "+agent.getAgentName() +", Id :  "+agentId);
			if(history.isEmpty()) {
				System.out.println(" No work history available.");
			}else {
				for(String issueId : history) {
					Issue issue = issues.get(issueId);
					if(issue != null) {
						System.out.println(" Issue : "+issue);
						if(issue.getStatus() == IssueStatus.RESOLVED) {
							System.out.println("   Resolution Time : "+issue.getResolvedAt());
						}
					}
				}
			}
			System.out.println();
		}
		
		//add issue;
		public void addIssue(String issueId, String userEmail, String desc, IssueType issueTypes) {
			if(issues.containsKey(issueId)) {
				throw new IllegalArgumentException(" Issue with ID : "+issueId+" is already exists");
			}
			
			Issue issue = new Issue(issueId, userEmail, desc, issueTypes);
			issues.put(issueId, issue);
			issueQueue.get(issueTypes).offer(issueId);
			
			System.out.println(" Issue created : "+issue);
			
			// Auto Assign
			tryAutoAssignment(issue);
		}
		
		public void tryAutoAssignment(Issue issue) {
			try {
				Agent availableAgents = findAvailableAgent(issue.getIssueType());
				if(availableAgents != null) {
					assignIssueToAgent(issue.getIssueId(), availableAgents.getAgentId());
				}
			} catch (Exception e) {
				// Issue in the Queue;
			}
		}
		
		
		//assign issue to agent;
		public void assignIssueToAgent(String issueId, String agentId) {
			Issue issue = getIssue(issueId);
			Agent agent = getAgent(agentId);
			
			if(!agent.setSpecializations(issue.getIssueType())) {
				throw new IllegalArgumentException(" Agent : "+agentId+" doest not have any specializations for "+issue.getIssueType());
			}
			
			if(issue.getStatus() == IssueStatus.RESOLVED) {
				throw new IllegalArgumentException(" Agent  "+agentId + " is currently busy ");
			}
			
			issue.setAssignedToAgent(agentId);
			issue.setStatus(IssueStatus.IN_PROGRESS);
			agent.setBusy(true);
			agent.addToWorkHistory(issueId);
			
			
			issueQueue.get(issue.getIssueType()).remove(issueId);
			System.out.println(" Issue : "+issueId+" assign to Agents : "+agentId);
		}
		// Update Issue Status 
		public void updateIssueStatus(String issueId, IssueStatus newStatus) {
			Issue issue = getIssue(issueId);
			
			if(newStatus == IssueStatus.RESOLVED) {
				throw new IllegalArgumentException(" Issue is already resolved markIssueResolved()");
			}
			
			if(issue.getStatus() == IssueStatus.RESOLVED){
				throw new IllegalArgumentException(" Cannot update issue for resolved status ");
			}
			
			issue.setStatus(newStatus);
			System.out.println(" Issue "+issueId+" is updated to "+newStatus);
		}
		
		// Mark issue as resolve
		public void markIssueAsresolved(String issueId) {
			Issue issue = getIssue(issueId);
			
			if(issue.getStatus() == IssueStatus.RESOLVED) {
				throw new IllegalArgumentException(" Issue is already resolved");
			}
			issue.setStatus(IssueStatus.RESOLVED);
			issue.setResolvedAt(java.time.LocalDateTime.now());
			
			String agentId = issue.getAssignedAgentId();
			if(agentId != null) {
				Agent agent = agents.get(agentId);
				if(agent != null) {
					agent.setBusy(false);
					
					assignNextIssueFormQueue(agent);
				}
			}
			
			System.out.println(" Issue : "+issueId+" marked as resolved");
			System.out.println(" Resolution time : "+issue.getResolutionsTimeInMinutes()+" minutes");
			
		}
		
		// fetch issue by status
		public void fetchIssueByStatus(IssueStatus status) {
			List<Issue> filteredStatus = issues.values().stream()
										.filter(issue -> issue.getStatus() == status)
										.collect(Collectors.toList());
			
			
			if(filteredStatus.isEmpty()) {
				throw new IllegalArgumentException(" No Issue found");
			}else {
				for(Issue issue : filteredStatus) {
					System.out.println(":   "+issue);
				}
			}
			
			System.out.println();
			
			
		}
		

		

		private void assignNextIssueFormQueue(Agent agent) {
			//  need to implement...
			
		}
		
		
		// calculaterAverageResolutionTime 
		public void calculaterAverageResolutionTime() {
			// login need to implement...
		}

		private Issue getIssue(String issueId) {
			//logic
			Issue issue  = issues.get(issueId);
			if(issue == null) {
				throw new IllegalArgumentException(" Issue not found ");
			}
			return issue;
		}

		public Agent findAvailableAgent(IssueType issueType) {
			// TODO Auto-generated method stub
			return agents.values().stream()
					.filter(agent -> agent.setSpecializations(issueType) && !agent.isBusy())
					.findFirst()
					.orElse(null);
		}

		private Agent getAgent(String agentId) {
			Agent agent = agents.get(agentId);
			if(agent == null) {
				throw new IllegalArgumentException(" Agent Not Found.");
			}
			return agent;
		}

		@SuppressWarnings("unchecked")
		public static void main(String[] args) {
			
			IncidentManagementSystem IMS = new IncidentManagementSystem();
			
			try {
				System.out.println("Incident Management System  ");
				
				
				// Add Agent
				System.out.println(" Adding Agents *************  ");
				IMS.addAgent("A1", "Raghu",  Arrays.asList(IssueType.PAYMENT_RELATED, IssueType.SPF));
				System.out.println(" *********** 2 ");
				IMS.viewAgentWorkHistory("A1");
				
				System.out.println("   Adding Issue ********* ");
				IMS.addIssue("IN1", "user@example.com", "I made a payment but it was not processed",IssueType.PAYMENT_RELATED);
				
				
				// 
				System.out.println(" \n fetch open issue \n ");
				IMS.fetchIssueByStatus(IssueStatus.OPEN);
				
				System.out.println(" \n Assign to Agent \n ");
				IMS.assignIssueToAgent("IN1", "A1");
				
				System.out.println(" \n Update Issue Status \n ");
				IMS.updateIssueStatus("IN1", IssueStatus.IN_PROGRESS);
				
				// Fetch Issues by Status 
				IMS.fetchIssueByStatus(IssueStatus.OPEN);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
}

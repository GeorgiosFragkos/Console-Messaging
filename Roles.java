package consoleProject;

public enum Roles {
	USER {
		public String toString() {
			return "USER";
		}
	},
	SUPERVISOR {
		public String toString() {
			return "SUPERVISOR";
		}
	},
	MANAGER {
		public String toString() {
			return "MANAGER";
		}
	},
	SUADMIN {
		public String toString() {
			return "SUADMIN";
		}
	}
}

class SecurityFilters {
   def filters = {
       loginCheck(controller: '*', action: '*') {
           before = {
			   accessControl {
				false
			   }
           }
       }
   }
}
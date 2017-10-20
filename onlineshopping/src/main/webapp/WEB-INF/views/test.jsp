<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<div class="modal fade" id="myCategoryModal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-head">
				<button type="button" class="close" data-dismiss="modal">
					<span>&time;</span>
				</button>
				<h4 class="modal-title">Add New Category</h4>
			</div>
			<div class="modal-body">
				<sf:form modelAttribute="category" class="form-horizontal"
					action="${contextRoot}/manage/category/product"
					method="RequestMethod.POST">
					
					<security:authorize access="isAnonimous('USER')">
					
					<div class="form-group">
						<label for="name" class="control-label col-md-4">category
							name</label>
						<div class="col-md-8">
							<sf:input path="name" type="text" class="form-control" />
						</div>
					</div>
           </security:authorize>

					<div class="form-group">
						<label for="category_description" class="control-label col-md-4">category
							description</label>
						<div class="col-md-8">
							<sf:textarea cols="" rows="5" path="description" type="text"
								id="category_description" class="form-control">
							</sf:textarea>
						</div>
					</div>
                   <div class="form-group">
                 <div class="col-md-offset-4 col-md-8">
                 <input type="submit" value="add category" class="btn btn-primary">
                 </div>
                 </div>
				</sf:form>



			</div>


		</div>



	</div>
     
						var api = this.api();
						api.$('.switch input[type="checkbox"]').on('change' , function() {							
							var dText = (this.checked)? 'You want to activate the Product?': 'You want to de-activate the Product?';
							var checked = this.checked;
							var checkbox = $(this);
							debugger;
						    bootbox.confirm({
						    	size: 'medium',
						    	title: 'Product Activation/Deactivation',
						    	message: dText,
						    	callback: function (confirmed) {
							        if (confirmed) {
							            $.ajax({							            	
							            	type: 'GET',
							            	url: window.contextRoot + '/manage/product/'+checkbox.prop('value')+'/activation',
							        		timeout : 100000,
							        		success : function(data) {
							        			bootbox.alert(data);							        										        			
							        		},
							        		error : function(e) {
							        			bootbox.alert('ERROR: '+ e);
							        			//display(e);
							        		}						            	
							            });
							        }
							        else {							        	
							        	checkbox.prop('checked', !checked);
							        }
						    	}
						    });																											
						});
							
						
/*	--------------------------------------------------------------------------------------------- */
						
						$('.switch input[type="checked"').on(change, function(){
							var checked =$(this);
							var mText =(this.checked)? 'do you want to activate the product?' :
								                        'do you want to deactivate the product?';
							
					})
	
		//	var $productTables =$('#productsTables');
		    if(productTables.length){
		    	var jsonUrl =window.contextRoot+'/json/data/admin/all/products';
		    	console.log(jsonUrl);
		    	$(productTables).dataTable({
		    		lengthMenu : [[10, 30, 50, -1], ['10 record', '30 record', '50 record', 'All']], 
		    		pageLenght : 30,
		    		ajax :{
		    		url : jsonUrl,
		    		dataSrc : ''
		    		},
		    		
		    		columns :[
		    		          { data :'id'},
		    		          
		    		          {data : 'code',
		    		           bSortable : false,
		    		             mRender : function(data, type, row){
		    		            	 return '<img src= "'+window.contextRoot+'/resources/images'+data+'.jpeg" class="dataTableImg"/>';
		    		             }
		    		          
		    		          },
		    		          
		    		          {data :'name' },
		    		          
		    		          {data : 'brand' },
		    		          
		    		          {data : 'quantity',
		    		        	mRender : function(data, type, row){
		    		        		
		    		        		if(data <1){
		    		        			return '<span style="color :red "> out of stock </span>'
		    		        		}
		    		        		return data
		    		        	}
		    		          },
		    		        	
		    		        	{data : 'unitPrice',
		    		        		
		    		        		mRender : function(data, type, row){
		    		        			return '4#8377;' + data
		    		        		}
		    		        	},
		    		        	
		    		        	{data : 'active',
		    		        		mRender : function(data, type, row){
		    		        			var str='';
		    		        			if(data){
		    		        				str += '<label class="switch"> <input type="checkbox" value="'+row.id+'" checked="checked">  <div class="slider round"> </div></label>';
		    		        			}
		    		        			else{
		    		        				str += '<label class="switch"> <input type="checkbox" value="'+row.id+'">  <div class="slider round"> </div></label>';
		    		        			}
		    		        			return str;
		    		        		}
		    		        		
		    		        		
		    		        	},
		    		        	
		    		        	{data : 'id',
		    		        		mRender : function(data, type, row){
		    		        		var str ='';	
		    		        		str ='<a img="'+window.contextRoot+'/manage/'+row.id+'/product" class="btn btn-primary"> <span class="glyphicon glyphicon-pencil"></span>&#160;</a>'
		    		        			return str;
		    		        		}
		    		        		
		    		        	}
		    		          
		    		          
		    		          ],
		    		
		    		   initComplete : function(){
	    		        	  var api =this.api();
	    		        	  api.$('switch input[type="checked"]').on(change, function(){
	    		        		var dText = (this.checked)? 'you want to activate the product ?':
	    		        			                         'you want to deactivate the product ?';
	    		        		var checked =(this.checked);
	    		        		var checkbox = $(this);
	    		        		debugger;
	    		        		bootbox.confirm({
	    		        			size: 'medium',
	    		        			title: 'product activation & deactivation',
	    		        			message: dText,
	    		        			callback: function(confirmed){
	    		        				if(confirmed){
	    		        					$.ajax({
	    		        						type: 'GET',
	    		        						url: window.contextRoot +'/manage/product'+checkbox.propt('value')+'/activation',
	    		        						timeout: 100000,
	    		        						success: function(data){
	    		        							bootbox.alert(data);
	    		        						},
	    		        					error: function(e){
    		        							bootbox.alert('ERROR ', +e)
    		        						}
	    		        					}) 
	    		        				}
	    		        				else{
	    		        					bootbox.alert('checked', !checked);
	    		        				}
	    		        			}
	    		        		});
	    		        		
	    		        	  });
	    		          }
		    	});
		    }			
						
				$categoryForm =$('#categoryForm');
				
				if($categoryForm.length){
					
					$categoryForm.validate({
					
					rule :{
						
						name: {
							required: true,
							minlength: 3
						},
				      
				        description: {
				        	 required : true,
				             minlength : 3
				        } 
					},
					
					messages :{
						
						name: {
							required : 'please enter your name',
							minlength :'please enter atleat five charactors'
							
						},
						
						description: {
							required: 'please enter your description',
							minlength: 'please write your description'
						}
					},
					
					errorElement : "em",
					errorPlacement : function(error, element){
						errorPlacement(error, element);
						
					}
			
				})
		}
				
				
				
				
				
				
				
				
				
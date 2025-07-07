import React, {useState } from 'react';
import { assets } from '../../assets/assets';
import { addFood } from '../../services/FoodService';
import { toast } from 'react-toastify';
const AddFood = () => {
  const [image, setImage] = useState(false);
  const [data, setData] = useState({
    name: '',
    description:'',
    category: 'biryani',
    price: ''
  });

  const onChangeHandler = (event) => {
    const name = event.target.name;
    const value = event.target.value;
    setData(data => ({...data, [name] : value}))
  }

  const onSubmithandler = async (event) => {
    event.preventDefault();

    if (!image) {
      toast.error("please select an image");
      return
    }
    try {
      await addFood(data, image);
      toast.success("Food Added Successfully")
      setData({
        name: '',
        description:'',
        category: 'biryani',
        price: ''
      });
      setImage(null);      
    } catch (error) {
      console.log(error);
      toast.error("Error adding Food!");
    }
  }
 
  return (
    <div className="mx-2 mt-2">
      <div className="row ">
        <div className="card col-md-4">
          <div className="card-body">
            <h2 className="mb-4" >Add Food</h2>
            <form onSubmit={onSubmithandler}>
              <div className="mb-3">
                <label htmlFor="image" className="form-label">
                  <img src={image ? URL.createObjectURL(image) : assets.upload} alt="" width = {75}/>
                </label>
                <input type="file" className="form-control" id="image"  hidden onChange={(e) => setImage(e.target.files[0])}/>
              </div>
              <div className="mb-3">
                <label htmlFor="name" className="form-label">Name</label>
                <input type="text" placeholder = 'Enter the name of the Food' className="form-control" id="name" required name='name' onChange={onChangeHandler} value={data.name}/>
              </div>
             
              <div className="mb-3">
                <label htmlFor="description" className="form-label">Description</label>
                <textarea className="form-control" placeholder='Write a description for the Food' id="description" rows="4" required name='description' onChange={onChangeHandler} value={data.description}></textarea>
              </div>
              <div className="mb-3">
                <label htmlFor="name" className="form-label">Category</label>
                <select name="category" id="category" className='form-control' onChange={onChangeHandler} value={data.category}>
                  <option value="biryani">Biryani</option>
                  <option value="burger">Burger</option>
                  <option value="cakes">Cakes</option>
                  <option value="icecream">Ice cream</option>
                  <option value="pizza">Pizza</option>
                  <option value="rolls">Rolls</option>
                  <option value="salad">Salad</option>
                </select>
                <div className="mb-3">
                <label htmlFor="price" className="form-label">Price</label>
                <input type="number" className="form-control" placeholder='&#8377;' id="price" required name='price' onChange={onChangeHandler} value={data.price}/>
              </div>
              </div>
              <button type="submit" className="btn btn-primary">Save</button>
            </form>
          </div>
        </div>
      </div>
    </div>
  )
}

export default AddFood;  
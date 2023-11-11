import React from 'react'
import axios from 'axios';
import { useParams, Link } from 'react-router-dom'

function Product() {
	const { Id } = useParams();
	const [product, setProduct] = React.useState();

	React.useEffect(() => {
		fetch(`/getProduct?Id=${Id}`)
			.then(res => res.json())
			.then(response => {
				setProduct(response[0]);
			});
	}, [Id])
	const handleAddToCart = () => {
		alert("Đã thêm sản phẩm vào giỏ hàng");
		axios.post('/cart/add', null, {
			params: {
				productId: parseInt(Id)
			}
		})
	}
	return (
		<div className="grid__row detail">
			{product !== undefined ? (
				<>
					<div className="grid__column-6 detail__picture">
						<img src={`/Images/sp/${product.Picture}`} alt="product" />
					</div>
					<div className="grid__column-6 detail__info">
						<div className="detail__info_heading">
							<span className="home_filter__page_num">
								<Link to="/store" className="myactionlink">Store</Link>
							</span>
							<h1 className="detail__info_name">
								{product.Name}
							</h1>
							<div className="detail__info_price">
								{product.Sale > 0 && (
									<span className="detail__info_price__cost">
										{product.costPrice.toLocaleString()}
										<span className="detail__info_price__symbol">đ</span>
									</span>
								)}
								<span className="detail__info_price__unit">
									{product.unitPrice.toLocaleString()}
									<span className="detail__info_price__symbol">đ</span>
								</span>
							</div>
						</div>

						<button
							type="button"
							className="btn detail__info_button_addtoCart"
							onClick={() => handleAddToCart()}
						>
							Thêm vào giỏ hàng
						</button>
					</div>
				</>
			) : (
				<>
					<span className="validate">Sản phẩm hiện đang hết hàng, vui lòng quay lại sau.</span>
				</>
			)
			}
		</div >

	)
}
export default React.memo(Product)
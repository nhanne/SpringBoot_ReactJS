import React from 'react'
import { Link } from 'react-router-dom'
import { FilterContext } from '../storeContext.js'

function Products() {
	const context = React.useContext(FilterContext);
	const products = context.products;
	return (
		<>
			{products.length > 0 ? (
				<ul id="products" className="row">
					{products.map(product => (
						<li key={product.Id} className='product-item'>
							<div className="product-top">
								<Link
									className="product-thumb"
									to={`./product/${product.Id}`}>
									<img
										src={`/Images/sp/${product.Picture}`}
										style={{ maxHeight: '200px' }}
									/>
								</Link>
								<Link className="buynow"
									title="Order"
									to={`./Product/${product.Id}`} >
									Xem ngay
								</Link>
							</div>
							<div className="product-info">
								{/* <a className="product-cat">{product.cateName}</a> */}
								<a className="product-name">{product.Name}</a>
								<div className="product-price">
									<span> </span>
									<span className="product--unitPrice">{product.unitPrice.toLocaleString()} VND
										<span className="product--currentPrice"></span>
									</span>
								</div>
								{product.Sale > 0 && (
									<div className="store-product__sale-off">
										<span className="store-product__sale-off-percent">{product.Sale}% </span>
										<span className="store-product__sale-off-label">Sale</span>
									</div>
								)}
							</div>
						</li>
					))}
				</ul>
			) : (
				<span style={{ display: 'block', padding: '12px 16px' }}>Không tìm thấy sản phẩm
					<span style={{ fontWeight: 'bold', fontSize: '2rem' }}> {context.search} </span>.
				</span>
			)}
			{/* <Pagination /> */}
		</>

	)
}

export default Products
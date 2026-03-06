import React, { useState } from 'react';
import { useNavigate, Link } from 'react-router-dom';

const Register = () => {
    const [formData, setFormData] = useState({
        username: '',
        email: '',
        password: '',
        phoneNumber: ''
    });
    const [message, setMessage] = useState('');
    const navigate = useNavigate();

    const handleChange = (e) => {
        setFormData({ ...formData, [e.target.name]: e.target.value });
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        try {
            const response = await fetch('http://localhost:8088/api/auth/register', {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify(formData)
            });
            if (response.ok) {
                setMessage('Registration successful! Redirecting to login...');
                setTimeout(() => navigate('/login'), 2000);
            } else {
                const errorData = await response.text();
                setMessage('Registration failed: ' + errorData);
            }
        } catch (error) {
            setMessage('Error: ' + error.message);
        }
    };

    return (
        <div className="auth-container">
            <form onSubmit={handleSubmit} className="auth-form">
                <h2>Register</h2>
                {message && <p className="message">{message}</p>}
                <input type="text" name="username" placeholder="Username" onChange={handleChange} required />
                <input type="email" name="email" placeholder="Email" onChange={handleChange} required />
                <input type="password" name="password" placeholder="Password" onChange={handleChange} required />
                <input type="text" name="phoneNumber" placeholder="Phone Number (e.g., +1234567890)" onChange={handleChange} required />
                <button type="submit">Register</button>
                <p>Already have an account? <Link to="/login">Login here</Link></p>
            </form>
        </div>
    );
};

export default Register;

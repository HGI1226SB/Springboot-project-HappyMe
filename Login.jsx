import React, { useState } from 'react';
import { useNavigate, Link } from 'react-router-dom';

const Login = ({ setUser }) => {
    const [step, setStep] = useState(1); // 1: Password, 2: OTP
    const [credentials, setCredentials] = useState({ username: '', password: '' });
    const [otp, setOtp] = useState('');
    const [phoneNumber, setPhoneNumber] = useState('');
    const [message, setMessage] = useState('');
    const navigate = useNavigate();

    const handleCredentialsChange = (e) => {
        setCredentials({ ...credentials, [e.target.name]: e.target.value });
    };

    const handleLogin = async (e) => {
        e.preventDefault();
        try {
            const response = await fetch('http://localhost:8088/api/auth/login', {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify(credentials)
            });
            if (response.ok) {
                const data = await response.json();
                setPhoneNumber(data.phoneNumber);
                setStep(2);
                setMessage('OTP sent to ' + data.phoneNumber);
            } else {
                const error = await response.text();
                setMessage('Login failed: ' + error);
            }
        } catch (error) {
            setMessage('Error: ' + error.message);
        }
    };

    const handleVerifyOtp = async (e) => {
        e.preventDefault();
        try {
            const response = await fetch('http://localhost:8088/api/auth/verify-otp', {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify({ phoneNumber, otp })
            });
            if (response.ok) {
                setMessage('Login successful!');
                setUser({ username: credentials.username });
                navigate('/home');
            } else {
                const error = await response.text();
                setMessage('Verification failed: ' + error);
            }
        } catch (error) {
            setMessage('Error: ' + error.message);
        }
    };

    return (
        <div className="auth-container">
            {step === 1 ? (
                <form onSubmit={handleLogin} className="auth-form">
                    <h2>Login</h2>
                    {message && <p className="message">{message}</p>}
                    <input type="text" name="username" placeholder="Username" onChange={handleCredentialsChange} required />
                    <input type="password" name="password" placeholder="Password" onChange={handleCredentialsChange} required />
                    <button type="submit">Send OTP</button>
                    <p>Don't have an account? <Link to="/register">Register here</Link></p>
                </form>
            ) : (
                <form onSubmit={handleVerifyOtp} className="auth-form">
                    <h2>Verify OTP</h2>
                    {message && <p className="message">{message}</p>}
                    <p>Enter the 6-digit code sent to your mobile.</p>
                    <input type="text" placeholder="Enter OTP" value={otp} onChange={(e) => setOtp(e.target.value)} required />
                    <button type="submit">Verify & Login</button>
                    <button type="button" onClick={() => setStep(1)} className="secondary-btn">Back to Login</button>
                </form>
            )}
        </div>
    );
};

export default Login;

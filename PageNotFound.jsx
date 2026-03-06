import React from 'react';
import { useNavigate } from 'react-router-dom';
import { FiHome, FiAlertTriangle } from 'react-icons/fi';

const PageNotFound = () => {
    const navigate = useNavigate();

    return (
        <div className="notfound-container" style={{
            minHeight: '100vh',
            display: 'flex',
            flexDirection: 'column',
            alignItems: 'center',
            justifyContent: 'center',
            padding: '2rem',
            textAlign: 'center',
            backgroundColor: 'var(--bg-darker)',
            position: 'relative',
            overflow: 'hidden'
        }}>
            <div style={{
                position: 'absolute',
                top: '50%',
                left: '50%',
                width: '600px',
                height: '600px',
                background: 'radial-gradient(circle, rgba(229, 9, 20, 0.4) 0%, transparent 70%)',
                transform: 'translate(-50%, -50%)',
                filter: 'blur(50px)',
                zIndex: 0
            }}></div>

            <div style={{ position: 'relative', zIndex: 1 }}>
                <FiAlertTriangle style={{ fontSize: '8rem', color: 'var(--primary)', marginBottom: '2rem' }} />

                <h1 className="font-heading" style={{ fontSize: '10rem', fontWeight: '800', lineHeight: '1', marginBottom: '1rem', textShadow: '0 0 50px rgba(229, 9, 20, 0.5)' }}>
                    404
                </h1>

                <h2 className="font-heading" style={{ fontSize: '2.5rem', marginBottom: '1.5rem', color: 'white' }}>
                    Lost in Space?
                </h2>

                <p style={{ fontSize: '1.25rem', color: 'var(--text-muted)', maxWidth: '500px', margin: '0 auto 3rem', lineHeight: '1.6' }}>
                    The page you're searching for seems to have vanished into the digital void. Let's get you back home!
                </p>

                <div className="button-group" style={{ display: 'flex', gap: '1rem', justifyContent: 'center' }}>
                    <button className="btn btn-primary" onClick={() => navigate('/home')}>
                        <FiHome /> Take Me Home
                    </button>
                    <button className="btn btn-outline" onClick={() => navigate(-1)}>
                        Go Back
                    </button>
                </div>
            </div>

            <img
                src="https://images.unsplash.com/photo-1578328819058-b69f3a3b0f6b?auto=format&fit=crop&w=400&q=80"
                alt="Lost Robot"
                style={{
                    position: 'absolute',
                    bottom: '5%',
                    right: '5%',
                    width: '300px',
                    opacity: '0.4',
                    borderRadius: '50%',
                    transform: 'rotate(-15deg)'
                }}
            />
        </div>
    );
};

export default PageNotFound;

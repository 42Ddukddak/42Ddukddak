import '../styles/globals.css'
import Layout from '@/components/Layout'

interface MyAppProps {
  Component: any
  pageProps: any
}

export default function MyApp({ Component, pageProps }: MyAppProps) {
  return (
    <Layout>
      <Component {...pageProps} />
    </Layout>
  )
}
